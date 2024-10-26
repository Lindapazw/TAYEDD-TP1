public class AplicacionVuelos {
    public static void main(String[] args) throws Exception {
        GrafoMatriz grafoVuelos = cargarVuelosGoodFly();
        System.out.println(grafoVuelos);

        BusquedaAnchura busqueda = new BusquedaAnchura(grafoVuelos, 0);
        busqueda.ejecutar();
        System.out.println(busqueda);
        
        // Identificar si el grafo es acíclico
        if (grafoVuelos.esAciclico()) {
            System.out.println("El grafo es acíclico.");
        } else {
            System.out.println("El grafo contiene ciclos.");
        }
    }

    private static GrafoMatriz cargarVuelosGoodFly() {
        String vuelosData = "(d1,d2,200),(d1,d13,250),(d1,d9,290),(d2,d6,360),(d2,d3,190),(d3,d6,250),(d3,d5,190),(d3,d1,300),(d4,d3,180),(d5,d6,300),(d5,d10,400),(d6,d11,350),(d6,d12,300),(d7,d4,300),(d7,d3,250),(d7,d1,150),(d8,d7,200),(d8,d1,220),(d9,d8,180),(d9,d13,180),(d10,d4,200),(d11,d10,700),(d11,d5,200),(d12,d2,150),(d13,d12,100),(d13,d2,200)";

        String[] vuelos = vuelosData.split("(?<=\\)),(?=\\()");
        GrafoMatriz grafo = new GrafoMatriz(13);

        for (String vuelo : vuelos) {
            String[] detalles = vuelo.replaceAll("[()]", "").split(",");
            int origen = Integer.parseInt(detalles[0].substring(1)) - 1;
            int destino = Integer.parseInt(detalles[1].substring(1)) - 1;
            int costo = Integer.parseInt(detalles[2]);

            grafo.agregarConexion(origen, destino, costo);
        }

        return grafo;
    }
}
