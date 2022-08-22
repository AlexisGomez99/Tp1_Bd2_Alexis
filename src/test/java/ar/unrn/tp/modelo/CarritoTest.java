package ar.unrn.tp.modelo;

import ar.unrn.tp.exception.EmailException;
import ar.unrn.tp.exception.NotNullException;
import ar.unrn.tp.exception.NotNumException;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarritoTest {

    @Test
    public void calcularMontoTotalConDescuentosCaducados() throws ParseException {
        try {
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("Visa",DateConverter.convertToDate(LocalDate.now().plusYears(3)),123,10000);
        Cliente cliente = new Cliente("Alexis","Gómez","ralexisge@gmail.com","42456256",tarjeta);
        Producto prod1 = new Producto(1,"Remeras","Deportiva","800",new Marca("Nike"));
        Producto prod2 = new Producto(2,"Pantalon","Deportiva","900",new Marca("Nike"));
        Producto prod3 = new Producto(3,"Zapatillas","Deportiva","2000",new Marca("Gucci"));

        Date fechaPromoInicio1 = DateConverter.convertToDate(LocalDate.now().plusDays(-10));
        Date fechaPromoInicio2 = DateConverter.convertToDate(LocalDate.now().plusDays(-30));
        Date fechaPromoFin1 = DateConverter.convertToDate(LocalDate.now().plusDays(-3));
        Date fechaPromoFin2 = DateConverter.convertToDate(LocalDate.now().plusDays(-27));

        List<Promocion> promocions = new ArrayList<>();
        promocions.add(new PromocionPorProducto(fechaPromoInicio1,fechaPromoFin1,new Marca("Nike"),0.05));
        promocions.add(new PromocionPorPago(fechaPromoInicio2,fechaPromoFin2,tarjeta,0.08));
        Carrito carrito = new Carrito(promocions);

        carrito.agregarProducto(prod1);
        carrito.agregarProducto(prod2);
        carrito.agregarProducto(prod3);

        double resultadoEsperado = 3700.0;
        carrito.asociarCliente(cliente);
        carrito.asociarTarjeta(tarjeta);
            System.out.println(carrito.calcularDescuento());
            TestCase.assertEquals(resultadoEsperado,carrito.calcularDescuento(),0.001);
        } catch (NotNullException | NotNumException | EmailException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void descuentoVigenteParaMarcaAcme() throws ParseException {
        try {
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("Visa",DateConverter.convertToDate(LocalDate.now().plusYears(3)),123,10000);
        Cliente cliente = new Cliente("Alexis","Gómez","ralexisge@gmail.com","42456256",tarjeta);
        Producto prod1 = new Producto(1,"Remeras","Deportiva","800",new Marca("Acme"));
        Producto prod2 = new Producto(2,"Pantalon","Deportiva","900",new Marca("Acme"));
        Producto prod3 = new Producto(3,"Zapatillas","Deportiva","2000",new Marca("Gucci"));

        Date fechaPromoInicio1 = DateConverter.convertToDate(LocalDate.now().plusDays(-10));
        Date fechaPromoInicio2 = DateConverter.convertToDate(LocalDate.now().plusDays(-30));
        Date fechaPromoFin1 = DateConverter.convertToDate(LocalDate.now().plusDays(10));
        Date fechaPromoFin2 = DateConverter.convertToDate(LocalDate.now().plusDays(-27));

        List<Promocion> promocions = new ArrayList<>();
        promocions.add(new PromocionPorProducto(fechaPromoInicio1,fechaPromoFin1,new Marca("Acme"),0.05));
        promocions.add(new PromocionPorPago(fechaPromoInicio2,fechaPromoFin2,tarjeta,0.08));
        Carrito carrito = new Carrito(promocions);

        carrito.agregarProducto(prod1);
        carrito.agregarProducto(prod2);
        carrito.agregarProducto(prod3);

        double resultadoEsperado = 3615.0;
        carrito.asociarCliente(cliente);
        carrito.asociarTarjeta(tarjeta);
            System.out.println(carrito.calcularDescuento());
            TestCase.assertEquals(resultadoEsperado,carrito.calcularDescuento(),0.001);
        } catch (NotNullException | NotNumException | EmailException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void descuentoVigenteParaMedioDePagoVisa() throws ParseException {
        try {
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("Visa",DateConverter.convertToDate(LocalDate.now().plusYears(3)),123,10000);
        Cliente cliente = new Cliente("Alexis","Gómez","ralexisge@gmail.com","42456256",tarjeta);
        Producto prod1 = new Producto(1,"Remeras","Deportiva","800",new Marca("Acme"));
        Producto prod2 = new Producto(2,"Pantalon","Deportiva","900",new Marca("Acme"));
        Producto prod3 = new Producto(3,"Zapatillas","Deportiva","2000",new Marca("Gucci"));

        Date fechaPromoInicio1 = DateConverter.convertToDate(LocalDate.now().plusDays(-10));
        Date fechaPromoInicio2 = DateConverter.convertToDate(LocalDate.now().plusDays(-30));
        Date fechaPromoFin1 = DateConverter.convertToDate(LocalDate.now().plusDays(-3));
        Date fechaPromoFin2 = DateConverter.convertToDate(LocalDate.now().plusDays(27));

        List<Promocion> promocions = new ArrayList<>();
        promocions.add(new PromocionPorProducto(fechaPromoInicio1,fechaPromoFin1,new Marca("Acme"),0.05));
        promocions.add(new PromocionPorPago(fechaPromoInicio2,fechaPromoFin2,tarjeta,0.08));
        Carrito carrito = new Carrito(promocions);

        carrito.agregarProducto(prod1);
        carrito.agregarProducto(prod2);
        carrito.agregarProducto(prod3);

        carrito.asociarCliente(cliente);
        carrito.asociarTarjeta(tarjeta);
        double resultadoEsperado = 3404.0;
        carrito.asociarCliente(cliente);
        carrito.asociarTarjeta(tarjeta);
            System.out.println(carrito.calcularDescuento());
            TestCase.assertEquals(resultadoEsperado,carrito.calcularDescuento(),0.001);
        } catch (NotNullException | NotNumException | EmailException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void descuentoVigenteParaMedioDePagoMemeCardYMarcaComarca() throws ParseException {
        try {
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("MemeCard",DateConverter.convertToDate(LocalDate.now().plusYears(3)),123,10000);
            Cliente cliente = new Cliente("Alexis","Gómez","ralexisge@gmail.com","42456256",tarjeta);
        Producto prod1 = new Producto(1,"Remeras","Deportiva","800",new Marca("Comarca"));
        Producto prod2 = new Producto(2,"Pantalon","Deportiva","900",new Marca("Comarca"));
        Producto prod3 = new Producto(3,"Zapatillas","Deportiva","2000",new Marca("Gucci"));

        Date fechaPromoInicio1 = DateConverter.convertToDate(LocalDate.now().plusDays(-10));
        Date fechaPromoInicio2 = DateConverter.convertToDate(LocalDate.now().plusDays(-30));
        Date fechaPromoFin1 = DateConverter.convertToDate(LocalDate.now().plusDays(3));
        Date fechaPromoFin2 = DateConverter.convertToDate(LocalDate.now().plusDays(27));

        List<Promocion> promocions = new ArrayList<>();
        promocions.add(new PromocionPorProducto(fechaPromoInicio1,fechaPromoFin1,new Marca("Comarca"),0.05));
        promocions.add(new PromocionPorPago(fechaPromoInicio2,fechaPromoFin2,tarjeta,0.08));
        Carrito carrito = new Carrito(promocions);

        carrito.agregarProducto(prod1);
        carrito.agregarProducto(prod2);
        carrito.agregarProducto(prod3);

        carrito.asociarCliente(cliente);
        carrito.asociarTarjeta(tarjeta);
        double resultadoEsperado = 3319.0;
        //Como aplicar el descuento de total y por separado

            System.out.println(carrito.calcularDescuento());
            TestCase.assertEquals(resultadoEsperado,carrito.calcularDescuento(),0.001);
        } catch (NotNullException | NotNumException | EmailException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void verificarPagoYGenerarVenta() throws ParseException {
        try {
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("MemeCard",DateConverter.convertToDate(LocalDate.now().plusYears(3)),123,10000);
        Cliente cliente = new Cliente("Alexis","Gómez","ralexisge@gmail.com","42456256",tarjeta);
        Producto prod1 = new Producto(1,"Remeras","Deportiva","800",new Marca("Comarca"));
        Producto prod2 = new Producto(2,"Pantalon","Deportiva","900",new Marca("Comarca"));
        Producto prod3 = new Producto(3,"Zapatillas","Deportiva","2000",new Marca("Gucci"));
        List<Producto> productos= new ArrayList<>();
        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);

        Date fechaPromoInicio1 = DateConverter.convertToDate(LocalDate.now().plusDays(-10));
        Date fechaPromoInicio2 = DateConverter.convertToDate(LocalDate.now().plusDays(-30));
        Date fechaPromoFin1 = DateConverter.convertToDate(LocalDate.now().plusDays(3));
        Date fechaPromoFin2 = DateConverter.convertToDate(LocalDate.now().plusDays(27));

        List<Promocion> promocions = new ArrayList<>();
        promocions.add(new PromocionPorProducto(fechaPromoInicio1,fechaPromoFin1,new Marca("Comarca"),0.05));
        promocions.add(new PromocionPorPago(fechaPromoInicio2,fechaPromoFin2,tarjeta,0.08));
        Carrito carrito = new Carrito(promocions);

        carrito.agregarProducto(prod1);
        carrito.agregarProducto(prod2);
        carrito.agregarProducto(prod3);

        carrito.asociarCliente(cliente);
        carrito.asociarTarjeta(tarjeta);

        double resultadoEsperado = 6681.0;

            System.out.println(carrito.calcularDescuento());
            TestCase.assertNotNull(carrito.comprarListado());
            TestCase.assertEquals(resultadoEsperado,cliente.obtenerTarjeta(0).getTotal(),0.001);
        } catch (NotNullException | NotNumException | EmailException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void verificarProductoConCategoriaDescripcionYPrecio() throws ParseException {
        try {
            Producto prod1 = new Producto(1,"Remeras",null,"800",new Marca("Comarca"));
        } catch (NotNullException | NotNumException e) {
            String menssage = "El campo categoria es null";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }
        try {
            Producto prod2 = new Producto(1,null,"Deportivo","800",new Marca("Comarca"));
        } catch (NotNullException | NotNumException e) {
            String menssage = "El campo descripcion es null";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }
        try {
            Producto prod3 = new Producto(1,"Remeras","Deportivo",null,new Marca("Comarca"));
        } catch (NotNullException | NotNumException e) {
            String menssage = "El campo precio es null";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }
        try {
            Producto prod4 = new Producto(1,"Remeras","Deportivo","8asd00",new Marca("Comarca"));
        } catch (NotNullException | NotNumException e) {
            String menssage = "Debe ser un valor numerico";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }
    }
    @Test
    public void verificarClienteConNombreApellidoDniYEmail() throws ParseException {
        try {
            Cliente cliente = new Cliente(null,"Gómez","ralexisge@gmail.com","42456256",null);
        } catch (NotNullException | NotNumException | EmailException e) {
            String menssage = "El campo nombre es null";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }
        try {
            Cliente cliente1 = new Cliente("Alexis",null,"ralexisge@gmail.com","42456256",null);
        } catch (NotNullException | NotNumException | EmailException e) {
            String menssage = "El campo apellido es null";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }
        try {
            Cliente cliente2 = new Cliente("Alexis","Gómez",null,"42456256",null);
        } catch (NotNullException | NotNumException | EmailException e) {
            String menssage = "El campo email es null";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }
        try {
            Cliente cliente3 = new Cliente("Alexis","Gómez","ralexisge@gmail.com",null,null);
        } catch (NotNullException | NotNumException | EmailException e) {
            String menssage = "El campo DNI es null";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }
        try {
            Cliente cliente4 = new Cliente("Alexis","Gómez","asdasd","42456256",null);
        } catch (NotNullException | NotNumException | EmailException e) {
            String menssage = "Ingrese un email valido.";
            TestCase.assertEquals("El mensaje es incorrecto",menssage,e.getMessage());
        }

    }
}
