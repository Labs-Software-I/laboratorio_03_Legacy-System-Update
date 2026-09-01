public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteresMensual;
    private static final double COMISION_MANEJO_FIJA = 10.0;

    public CuentaAhorros(String numeroCuenta, String titular, double saldoInicial, double tasaInteresMensual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    @Override
    protected boolean puedeRetirar(double monto) {
        return getSaldo() >= monto;
    }

    @Override
    public void aplicarComisionMensual() {
        double rendimientos = getSaldo() * tasaInteresMensual;
        double nuevoSaldo = getSaldo() + rendimientos - COMISION_MANEJO_FIJA;
        setSaldo(nuevoSaldo);
        System.out.println("Comisión aplicada en Cuenta Ahorros. Rendimientos: +" + rendimientos 
                           + " | Comisión fija: -" + COMISION_MANEJO_FIJA 
                           + " | Nuevo Saldo: $" + getSaldo());
    }

    public double getTasaInteresMensual() { return tasaInteresMensual; }
    public void setTasaInteresMensual(double tasaInteresMensual) { this.tasaInteresMensual = tasaInteresMensual; }
}