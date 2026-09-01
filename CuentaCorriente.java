public class CuentaCorriente extends CuentaBancaria {
    private double cupoSobregiro;
    private double comisionSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double cupoSobregiro, double comisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
        this.comisionSobregiro = comisionSobregiro;
    }

    @Override
    protected boolean puedeRetirar(double monto) {
        // Regla de negocio: Permite saldo negativo hasta el límite del cupo de sobregiro
        return (getSaldo() + cupoSobregiro) >= monto;
    }

    @Override
    public void aplicarComisionMensual() {
        if (getSaldo() < 0) {
            // Si la cuenta está en sobregiro, aplica el cobro por mora/comisión de sobregiro
            double cobroPorSobregiro = Math.abs(getSaldo()) * comisionSobregiro;
            setSaldo(getSaldo() - cobroPorSobregiro);
            System.out.println("Comisión aplicada por sobregiro: -" + cobroPorSobregiro 
                               + " | Nuevo Saldo: $" + getSaldo());
        } else {
            System.out.println("Sin cobros de sobregiro para la cuenta corriente " + getNumeroCuenta());
        }
    }

    public double getCupoSobregiro() { return cupoSobregiro; }
    public void setCupoSobregiro(double cupoSobregiro) { this.cupoSobregiro = cupoSobregiro; }
    public double getComisionSobregiro() { return comisionSobregiro; }
}   