public class CuentaCorriente extends CuentaBancaria {
    private final double cupoSobregiro;
    private final double comisionSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double cupoSobregiro, double comisionSobregiro) {
        super(numeroCuenta, titular, saldo);
        this.cupoSobregiro = cupoSobregiro;
        this.comisionSobregiro = comisionSobregiro;
    }

     @Override
    public void retirar(double monto) {
        if (monto > 0 && saldoSuficiente(monto)) {
            setSaldo(getSaldo() - monto);
        }
    }

    @Override
    protected boolean saldoSuficiente(double monto) {
        return (getSaldo() + cupoSobregiro) >= monto;
    }

      @Override
    public void aplicarComisionMensual() {
        if (getSaldo() < 0) {
            double cobroMora = Math.abs(getSaldo()) * comisionSobregiro;
            setSaldo(getSaldo() - cobroMora);
        }
    }

    public double getCupoSobregiro() { return cupoSobregiro; }
    public double getComisionSobregiro() { return comisionSobregiro; }
}   