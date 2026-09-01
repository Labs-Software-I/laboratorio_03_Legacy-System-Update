public abstract class CuentaBancaria {
    private final String numeroCuenta;
    private final String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
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