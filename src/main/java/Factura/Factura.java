package Factura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



class Factura {
    String descripcion;
    int importe;
    int cantidad;
    LocalDate fechaFactura;
    int codigoFactura;


    public Factura(String descripcion, int importe, int cantidad, LocalDate fechaFactura, int codigoFactura) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.cantidad = cantidad;
        this.fechaFactura = fechaFactura;
        this.codigoFactura = codigoFactura;
    }

    Factura(String descripcion, int importe){
        this.descripcion=descripcion;
        this.importe=importe;
    }

    int getImporte(){
        return importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "descripcion='" + descripcion + '\'' +
                ", importe=" + importe +
                ", cantidad=" + cantidad +
                ", fechaFactura=" + fechaFactura +
                ", codigoFactura=" + codigoFactura +
                '}';
    }

    public static void main(String[] args) {
        // registros de la data
        Factura f=new Factura("laptop",2500, 2, LocalDate.of(2005,10,16), 10);
        Factura f2=new Factura("Escritorio",600, 1, LocalDate.of(1999,3,15),50);
        Factura f3=new Factura("El mouse",300, 8, LocalDate.of(1985,2,11), 5);
        Factura f4 = new Factura("gomitas", 100,101, LocalDate.now(), 50);

        // generar una lista
        List<Factura> lista=new ArrayList<Factura>();

        // agregar los productos de la factura
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);



        Factura facturaFiltro=lista.stream()
                .filter(elemento->elemento.getImporte()>500)
                .findFirst().orElseThrow();

        System.out.println(facturaFiltro.getImporte());
        System.out.println("\n");



        System.out.println("FILTRO POR CANTIDAD DE PRODUCTOS");

        List<Factura> filtroCantidad= lista.stream()
                .filter(elemento -> elemento.getCantidad() >= 3)
                .collect(Collectors.toList());


        filtroCantidad.forEach(System.out::println);
        System.out.println("\n");


        System.out.println("FILTRO POR CODIGO DE FACTURA");
        Factura filtrarCodigo=lista.stream()
                .filter(elemento->elemento.getCodigoFactura() > 30)
                .findFirst().orElseThrow();

        System.out.println(filtrarCodigo);
        System.out.println("\n");


        System.out.println("FILTRAR POR FECHA DEL MISMO DIA");

        List<Factura> filtrarPorFechaIgual= lista.stream()
                .filter(elemento -> elemento.getFechaFactura().equals(LocalDate.now()))
                .collect(Collectors.toList());

        filtrarPorFechaIgual.forEach(System.out::println);
        System.out.println("\n");


        System.out.println("FILTRO POR FECHA MENORES");

        List<Factura> filtrarPorFechaMenor= lista.stream()
                .filter(elemento -> elemento.getFechaFactura().isBefore(LocalDate.of(1988, 5, 25)))

                .collect(Collectors.toList());

        filtrarPorFechaMenor.forEach(System.out::println);
        System.out.println("\n");

        //filtrar por fecha >
        System.out.println("FILTRO POR FECHA MAYORES");

        List<Factura> filtrarPorFechaMayor= lista.stream()
                .filter(elemento -> elemento.getFechaFactura().isAfter(LocalDate.of(2000, 1, 25)))
                .collect(Collectors.toList());

        filtrarPorFechaMayor.forEach(System.out::println);
        System.out.println("\n");
    }



}

