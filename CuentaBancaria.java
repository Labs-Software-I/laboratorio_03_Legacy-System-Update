public abstract class CuentaBancaria {
    private final String numeroCuenta;
    private final String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public boolean transferir(double monto, CuentaBancaria destino, RegistroAuditoriaBancaria auditoria) {
        if (monto > 0 && saldoSuficiente(monto)) {
            this.retirar(monto);
            auditoria.registrarEvento("Transferencia EXITOSA de $" + monto + " de " + getTitular() + " a " + destino.getTitular());
            return true;
        }

        auditoria.registrarEvento("Transferencia FALLIDA de $" + monto + " desde la cuenta de " + getTitular());
        return false;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
        } else {
            System.out.println("El monto a depositar debe ser mayor a cero.");
        }
    }

    public abstract void retirar(double monto);

    protected abstract boolean saldoSuficiente(double monto);

    public abstract void aplicarComisionMensual();

    // Getters y Setters
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    
    protected void setSaldo(double saldo) { this.saldo = saldo; }
}