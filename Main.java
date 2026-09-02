public class Main {
    public static void main(String[] args) {
        CuentaAhorros cuentaAhorros = new CuentaAhorros("1234", "David Alonso", 100000.0, 0.02, 10.0);
        CuentaCorriente cuentaCorriente = new CuentaCorriente("4321", "GanaMax", 1000000.0, 300.0, 0.05);

        try (RegistroAuditoriaBancaria auditoria = new RegistroAuditoriaBancaria()) {
            auditoria.registrarEvento("INICIO DE OPERACIONES BANCARIAS ===");

            cuentaAhorros.transferir(20000.0, cuentaCorriente, auditoria);
            
            cuentaCorriente.transferir(300000.0, cuentaAhorros, auditoria);

            cuentaAhorros.aplicarComisionMensual();
            cuentaCorriente.aplicarComisionMensual();

        } catch (Exception e) {
            System.err.println("Error procesando recursos: " + e.getMessage());
        }

    }
}