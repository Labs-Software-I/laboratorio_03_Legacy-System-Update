public class CuentaAhorros extends CuentaBancaria {
    private final double tasaInteresMensual;
    private final double comisionManejoMensual;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo, double tasaInteresMensual, comisionManejoMensual) {
        super(numeroCuenta, titular, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
        this.comisionManejoMensual = comisionManejoMensual;
    }

    @Override
    public void aplicarComisionMensual() {
        double comision = getSaldo() * tasaInteresMensual;
        setSaldo((getSaldo() + comision) - getComisionManejoMensual())
    }

    @Override
    protected boolean saldoSuficiente(double monto) {
        return getSaldo() >= monto;
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && saldoSuficiente(monto)) {
            setSaldo(getSaldo() - monto);
        }
    }

    public double getTasaInteresMensual() { return tasaInteresMensual; }
    public double getComisionManejoMensual() { return tasaInteresMensual; }
}