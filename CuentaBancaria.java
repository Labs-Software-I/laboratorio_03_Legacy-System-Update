public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("El monto a depositar debe ser mayor a cero.");
        }
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto no válido.");
            return false;
        }
        if (puedeRetirar(monto)) {
            this.saldo -= monto;
            System.out.println("Retiro exitoso de $" + monto + ". Saldo restante: $" + this.saldo);
            return true;
        } else {
            System.out.println("Retiro rechazado. Fondos o cupo insuficiente.");
            return false;
        }
    }

    protected abstract boolean puedeRetirar(double monto);

    public abstract void aplicarComisionMensual();

    // Getters y Setters
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    public double getSaldo() { return saldo; }
    protected void setSaldo(double saldo) { this.saldo = saldo; }
}