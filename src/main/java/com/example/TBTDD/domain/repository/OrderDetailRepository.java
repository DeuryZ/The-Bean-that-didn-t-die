package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.embeddable.OrderDetailId;
import com.example.TBTDD.persistence.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {



    // Devuelve un listado de los 20 productos más vendidos y el número total de
    // unidades que se han vendido de cada uno. El listado deberá estar ordenado por
    // el número total de unidades vendidas.
    @Query(value = "SELECT p.nombre AS nombre_producto, SUM(dp.cantidad) AS total_unidades_vendidas\n" +
            "FROM producto p\n" +
            "JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto\n" +
            "GROUP BY p.nombre\n" +
            "ORDER BY total_unidades_vendidas DESC\n" +
            "LIMIT 20;\n", nativeQuery = true)
    List<Object[]> findBestSellingProducts();

    //15. La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total facturado.
    // La base imponible se calcula sumando el coste del producto por el número de unidades vendidas de la tabla detalle_pedido`detalle_pedido`.
    // El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores.

        @Query(value = "SELECT SUM(dp.unitPrice * dp.quantity) AS baseImponible, " +
                "SUM(dp.unitPrice * dp.quantity) * 0.21 AS iva, " +
                "SUM(dp.unitPrice * dp.quantity) + (SUM(dp.unitPrice * dp.quantity) * 0.21) AS totalFacturado " +
                "FROM OrderDetail dp")
        Object[] calculateBilling();

    //La misma información que en la pregunta anterior, pero agrupada por código de producto.


    @Query(value = "SELECT dp.codigo_producto AS productCode,\n" +
            "       SUM(dp.precio_unidad * dp.cantidad) AS baseImponible,\n" +
            "       SUM(dp.precio_unidad * dp.cantidad) * 0.21 AS iva,\n" +
            "       SUM(dp.precio_unidad * dp.cantidad) + (SUM(dp.precio_unidad * dp.cantidad) * 0.21) AS totalFacturado\n" +
            "FROM detalle_pedido dp\n" +
            "GROUP BY dp.codigo_producto\n" +
            "ORDER BY SUM(dp.precio_unidad * dp.cantidad) DESC;\n", nativeQuery = true)
    List<Object[]> calculateBillingByProduct();
    //La misma información que en la pregunta anterior, pero agrupada por código de producto filtrada por los códigos que empiecen por OR
    @Query(value = "SELECT dp.codigo_producto AS productCode,\n" +
            "       SUM(dp.precio_unidad * dp.cantidad) AS baseImponible,\n" +
            "       SUM(dp.precio_unidad * dp.cantidad) * 0.21 AS iva,\n" +
            "       SUM(dp.precio_unidad * dp.cantidad) + (SUM(dp.precio_unidad * dp.cantidad) * 0.21) AS totalFacturado\n" +
            "FROM detalle_pedido dp\n" +
            "WHERE dp.codigo_producto LIKE 'OR%'\n" +
            "GROUP BY dp.codigo_producto\n" +
            "ORDER BY SUM(dp.precio_unidad * dp.cantidad) DESC;\n", nativeQuery = true)
    List<Object[]> calculateBillingByProductWithOR();

//  Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).
@Query(value = "SELECT p.nombre AS productName,\n" +
        "       SUM(dp.cantidad) AS totalAmount,\n" +
        "       SUM(dp.cantidad * dp.precio_unidad) AS baseImponible,\n" +
        "       SUM(dp.cantidad * dp.precio_unidad) * 1.21 AS iva\n" +
        "FROM producto p\n" +
        "JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto\n" +
        "GROUP BY p.nombre\n" +
        "HAVING SUM(dp.cantidad * dp.precio_unidad) > 3000;\n", nativeQuery = true)
List<Object[]> showVentsGreaterthan3000();

}
