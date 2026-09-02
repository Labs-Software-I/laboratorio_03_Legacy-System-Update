public class RegistroAuditoriaBancaria implements AutoCloseable {
    private boolean recursoAbierto = true;

    public void registrarEvento(String evento) {
        if (!recursoAbierto){
            throw new IllegalStateException("El registro de auditoría está cerrado.");
        }
        System.out.println("=== AUDITORIA: " + evento);
    }

    @Override
    public void close() {
        if (recursoAbierto) {
            System.out.println("[AUDITORÍA] Registro cerrado.");
            recursoAbierto = false;
        }
    }
}