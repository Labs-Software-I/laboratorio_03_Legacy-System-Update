public class RegistroAuditoria implements AutoCloseable {
    private boolean recursoAbierto = true;

    public void registrarEvento(String evento) {
        if (!abierto){
            throw new IllegalStateException("El registro de auditoría está cerrado.");
        }
        System.out.println("=== AUDITORIA: " + mensaje);
    }

    @Override
    public void close() {
        if (abierto) {
            System.out.println("[AUDITORÍA] Registro cerrado.");
            abierto = false;
        }
    }
}