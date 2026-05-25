//Libreria educativa Santillana
import java.util.Scanner;

public class Main
{
    private static LibroSantillana[] catalogoLibros = new LibroSantillana[120];
    private static int contadorLibros = 0;
    private static String[][] mapaAlmacen = new String[4][100];
    private static int[] contadorEstantes = new int[4];
    private static double presupuestoMensual = 500.0;

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                mapaAlmacen[i][j] = "VACIO";
            }
            contadorEstantes[i] = 0;
        }

        do
        {
            System.out.println("\n SISTEMA DE GESTION INTERNA DE LA PAPELERIA ");
            System.out.println("1. Recibir pedido de Editorial (Ingreso a bodega)");
            System.out.println("2. Localizar ubicacion de texto en perchas internas");
            System.out.println("3. Despachar textos a estanteria de atencion al publico");
            System.out.println("4. Revisar alertas de desabastecimiento critico");
            System.out.println("5. Ver caja chica para compras de reabastecimiento");
            System.out.println("6. Salir");
            System.out.print("Seleccione la opcion a realizar: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1)
            {
                if (contadorLibros >= 120)
                {
                    System.out.println("Error: Espacio maximo en el catalogo de la papeleria lleno.");
                    continue;
                }

                System.out.print("Ingrese el ID del texto: ");
                String id = teclado.nextLine();
                System.out.print("Ingrese el titulo del libro: ");
                String titulo = teclado.nextLine();
                System.out.print("Ingrese costo de adquisicion de la editorial: ");
                double costo = teclado.nextDouble();
                System.out.print("Ingrese precio marcado para venta final: ");
                double venta = teclado.nextDouble();
                System.out.print("Ingrese cantidad de textos que llegan en la caja: ");
                int stock = teclado.nextInt();
                System.out.print("Ingrese nivel de Educacion General Basica (1 a 10): ");
                int nivel = teclado.nextInt();
                System.out.println("Seleccione percha por materia (0: Ingles, 1: Matematica, 2: Arte, 3: Biologia): ");
                int materia = teclado.nextInt();
                teclado.nextLine();

                double costoTotalOrden = costo * stock;
                if (costoTotalOrden > presupuestoMensual)
                {
                    System.out.println("Error: No se puede recibir el lote. Excede el presupuesto mensual de la papeleria (" + presupuestoMensual + " USD).");
                    System.out.println("Se activara la clausula de devolucion por superar el limite financiero.");
                    continue;
                }

                if (contadorEstantes[materia] + stock > 100)
                {
                    System.out.println("Error: La percha de esa materia esta saturada. Solo quedan " + (100 - contadorEstantes[materia]) + " espacios fisicos.");
                    continue;
                }

                if (materia == 0)
                {
                    System.out.print("Ingrese nivel MCER (A1, A2, B1): ");
                    String mcer = teclado.nextLine();
                    LibroInglesSantillana li = new LibroInglesSantillana();
                    li.setIdLibro(id);
                    li.setTitulo(titulo);
                    li.setPrecioCosto(costo);
                    li.setPrecioVenta(venta);
                    li.setCantidadStock(stock);
                    li.setNivelEscolar(nivel);
                    li.setNivelMCER(mcer);
                    catalogoLibros[contadorLibros] = li;
                }
                else if (materia == 1)
                {
                    System.out.print("¿Trae el anexo desprendible de formulas? (true/false): ");
                    boolean formulario = teclado.nextBoolean();
                    LibroMatematicaSantillana lm = new LibroMatematicaSantillana();
                    lm.setIdLibro(id);
                    lm.setTitulo(titulo);
                    lm.setPrecioCosto(costo);
                    lm.setPrecioVenta(venta);
                    lm.setCantidadStock(stock);
                    lm.setNivelEscolar(nivel);
                    lm.setIncluyeFormulario(formulario);
                    catalogoLibros[contadorLibros] = lm;
                }
                else if (materia == 2)
                {
                    System.out.print("Ingrese tipo de papel / cartulina del block: ");
                    String cartulina = teclado.nextLine();
                    LibroArteSantillana la = new LibroArteSantillana();
                    la.setIdLibro(id);
                    la.setTitulo(titulo);
                    la.setPrecioCosto(costo);
                    la.setPrecioVenta(venta);
                    la.setCantidadStock(stock);
                    la.setNivelEscolar(nivel);
                    la.setTipoCartulina(cartulina);
                    catalogoLibros[contadorLibros] = la;
                }
                else if (materia == 3)
                {
                    System.out.print("¿Trae laminas anatomicas en 3D? (true/false): ");
                    boolean anatomia = teclado.nextBoolean();
                    LibroBiologiaSantillana lb = new LibroBiologiaSantillana();
                    lb.setIdLibro(id);
                    lb.setTitulo(titulo);
                    lb.setPrecioCosto(costo);
                    lb.setPrecioVenta(venta);
                    lb.setCantidadStock(stock);
                    lb.setNivelEscolar(nivel);
                    lb.setIncluyeAnatomia3D(anatomia);
                    catalogoLibros[contadorLibros] = lb;
                }

                contadorLibros++;

                int posicionLibreEnEstante = contadorEstantes[materia];
                for (int k = 0; k < stock; k++)
                {
                    mapaAlmacen[materia][posicionLibreEnEstante + k] = id;
                }
                contadorEstantes[materia] = contadorEstantes[materia] + stock;

                presupuestoMensual = presupuestoMensual - costoTotalOrden;
                System.out.println("PROCESO INTERNO: Textos acomodados en las perchas de la bodega.");
            }
            else if (opcion == 2)
            {
                System.out.print("Ingrese el codigo del texto a ubicar: ");
                String idBuscar = teclado.nextLine();
                boolean encontrado = false;

                for (int i = 0; i < contadorLibros; i++)
                {
                    if (catalogoLibros[i].getIdLibro().equals(idBuscar))
                    {
                        encontrado = true;
                        System.out.println("Texto localizado en sistema: " + catalogoLibros[i].getTitulo());

                        for (int f = 0; f < 4; f++)
                        {
                            for (int c = 0; c < 100; c++)
                            {
                                if (mapaAlmacen[f][c].equals(idBuscar))
                                {
                                    System.out.println("Ubicacion en percha: Fila de materia " + f + ", Casillero de almacenamiento " + c);
                                    f = 4;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }

                if (!encontrado)
                {
                    System.out.println("Aviso: No quedan existencias en bodega interna. Plazo de reposicion con la editorial: 2 semanas.");
                }
            }
            else if (opcion == 3)
            {
                System.out.print("Ingrese el codigo del texto que va a salir a mostrador: ");
                String idSalida = teclado.nextLine();
                boolean encontrado = false;

                for (int i = 0; i < contadorLibros; i++)
                {
                    if (catalogoLibros[i].getIdLibro().equals(idSalida))
                    {
                        encontrado = true;
                        System.out.println("Texto a mover: " + catalogoLibros[i].getTitulo());
                        System.out.println("Unidades disponibles en percha interna: " + catalogoLibros[i].getCantidadStock());
                        System.out.print("Ingrese la cantidad de unidades que bajaran a mostrador: ");
                        int cantidadADespachar = teclado.nextInt();
                        teclado.nextLine();

                        if (cantidadADespachar > catalogoLibros[i].getCantidadStock())
                        {
                            System.out.println("Error: No puedes sacar esa cantidad. Excede lo que hay guardado en la percha interna.");
                        }
                        else
                        {
                            int nuevoStock = catalogoLibros[i].getCantidadStock() - cantidadADespachar;
                            catalogoLibros[i].setCantidadStock(nuevoStock);

                            int eliminados = 0;
                            for (int f = 0; f < 4; f++)
                            {
                                for (int c = 99; c >= 0; c--)
                                {
                                    if (mapaAlmacen[f][c].equals(idSalida) && eliminados < cantidadADespachar)
                                    {
                                        mapaAlmacen[f][c] = "VACIO";
                                        eliminados++;
                                        contadorEstantes[f] = contadorEstantes[f] - 1;
                                    }
                                }
                            }

                            System.out.println("DESPACHO REALIZADO: Unidades movidas al mostrador exterior.");
                            System.out.println("Quedan " + nuevoStock + " unidades retenidas en la bodega interna.");
                        }
                        break;
                    }
                }

                if (!encontrado)
                {
                    System.out.println("Error: El codigo no corresponde a ningun lote registrado en la bodega.");
                }
            }
            else if (opcion == 4)
            {
                System.out.println("--- INFORMES DE REPOSICION URGENTE (MENOS DE 15 UNIDADES EN BODEGA) ---");
                for (int i = 0; i < contadorLibros; i++)
                {
                    if (catalogoLibros[i].getCantidadStock() < 15)
                    {
                        System.out.println("Alerta de Stock Faltante: " + catalogoLibros[i].getTitulo() + " (Codigo: " + catalogoLibros[i].getIdLibro() + ") registra solo " + catalogoLibros[i].getCantidadStock() + " unidades en percha.");
                    }
                }
            }
            else if (opcion == 5)
            {
                System.out.println("Capital asignado para compras del mes a Santillana: " + presupuestoMensual + " USD.");
            }

        } while (opcion != 6);

        System.out.println("Sistema de control interno cerrado.");
    }
}