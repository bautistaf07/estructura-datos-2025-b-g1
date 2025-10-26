import java.util.*;

/**
 * TallerEstructuras.java
 * Implementa: Pila (Deshacer/Rehacer), PriorityQueue, HashMap usuarios únicos,
 * Árbol Binario con recorridos, AVL con reporte de rotaciones, BST (buscar/insertar/eliminar),
 * Grafo (Dijkstra y BFS) y Proyecto integrador (Grafo + Pila).
 *
 * Ejecuta main() para ver demostraciones de cada entregable.
 */
public class TallerEstructuras {

    /* ===================== 1) PILA: Editor Deshacer/Rehacer ===================== */
    static class EditorHistory {
        private Deque<String> undo = new ArrayDeque<>();
        private Deque<String> redo = new ArrayDeque<>();
        private String text = "";

        // Escribir reemplaza el contenido actual (simple para evidencias)
        public void type(String newText) {
            undo.push(text);
            text = newText;
            redo.clear();
        }

        public boolean undo() {
            if (undo.isEmpty()) return false;
            redo.push(text);
            text = undo.pop();
            return true;
        }

        public boolean redo() {
            if (redo.isEmpty()) return false;
            undo.push(text);
            text = redo.pop();
            return true;
        }

        public String getText() { return text; }

        // Complejidad: push/pop O(1), undo/redo O(1)
    }

    /* ================== 2) COLA CON PRIORIDAD: Sistema de atención ============== */
    static class Ticket implements Comparable<Ticket> {
        // Menor número = mayor prioridad (0 = crítico)
        final int prioridad;
        final String cliente;
        final long llegada; // desempate: primero en llegar

        Ticket(int prioridad, String cliente, long llegada) {
            this.prioridad = prioridad;
            this.cliente = cliente;
            this.llegada = llegada;
        }

        @Override
        public int compareTo(Ticket o) {
            if (this.prioridad != o.prioridad) return Integer.compare(this.prioridad, o.prioridad);
            return Long.compare(this.llegada, o.llegada);
        }

        @Override
        public String toString() {
            return "[prio=" + prioridad + ", cliente=" + cliente + "]";
        }
    }

    static class CentroAtencion {
        private PriorityQueue<Ticket> pq = new PriorityQueue<>();
        private long reloj = 0;

        public void nuevoTicket(String cliente, int prioridad) {
            pq.add(new Ticket(prioridad, cliente, reloj++));
        }

        public Ticket atender() {
            return pq.poll();
        }

        public boolean vacio() { return pq.isEmpty(); }
        // Complejidad: inserción O(log n), extracción O(log n)
    }

    /* ===================== 3) HASHMAP: Usuarios únicos por ID ==================== */
    static class Usuario {
        final int id;
        final String nombre;
        Usuario(int id, String nombre) { this.id = id; this.nombre = nombre; }
        @Override public String toString() { return id + ":" + nombre; }
    }

    static class UserRepo {
        private final Map<Integer, Usuario> mapa = new HashMap<>();

        public boolean agregar(Usuario u) {
            if (mapa.containsKey(u.id)) return false; // evita duplicados por ID
            mapa.put(u.id, u);
            return true;
        }

        public Usuario obtener(int id) { return mapa.get(id); }

        public Collection<Usuario> todos() { return mapa.values(); }
        // Complejidad promedio: insertar/buscar O(1). Peor caso: O(n).
    }

    /* ==================== 4) ÁRBOL BINARIO: recorridos básicos ================== */
    static class NodoBin {
        int valor;
        NodoBin izq, der;
        NodoBin(int v) { valor = v; }
    }

    static class ArbolBinario {
        NodoBin raiz;

        public void insertar(int v) { raiz = insertarRec(raiz, v); }
        private NodoBin insertarRec(NodoBin n, int v) {
            if (n == null) return new NodoBin(v);
            if (v < n.valor) n.izq = insertarRec(n.izq, v);
            else n.der = insertarRec(n.der, v);
            return n;
        }

        public List<Integer> enOrden() { List<Integer> r = new ArrayList<>(); enOrden(raiz, r); return r; }
        private void enOrden(NodoBin n, List<Integer> r) {
            if (n == null) return;
            enOrden(n.izq, r); r.add(n.valor); enOrden(n.der, r);
        }

        public List<Integer> preOrden() { List<Integer> r = new ArrayList<>(); preOrden(raiz, r); return r; }
        private void preOrden(NodoBin n, List<Integer> r) {
            if (n == null) return;
            r.add(n.valor); preOrden(n.izq, r); preOrden(n.der, r);
        }

        public List<Integer> postOrden() { List<Integer> r = new ArrayList<>(); postOrden(raiz, r); return r; }
        private void postOrden(NodoBin n, List<Integer> r) {
            if (n == null) return;
            postOrden(n.izq, r); postOrden(n.der, r); r.add(n.valor);
        }
        // Complejidad de los recorridos: O(n)
    }

    /* ==================== 5) AVL: inserción + reporte de rotaciones ============== */
    static class NodoAVL {
        int v, h = 1;
        NodoAVL izq, der;
        NodoAVL(int v){ this.v = v; }
    }

    static class AVL {
        NodoAVL raiz;
        final List<String> rotacionesRealizadas = new ArrayList<>();

        public void insertar(int v) { raiz = insertarRec(raiz, v); }

        private int altura(NodoAVL n){ return n == null ? 0 : n.h; }
        private int balance(NodoAVL n){ return n == null ? 0 : altura(n.izq) - altura(n.der); }

        private NodoAVL rotDer(NodoAVL y){
            NodoAVL x = y.izq;
            NodoAVL T2 = x.der;
            x.der = y; y.izq = T2;
            y.h = Math.max(altura(y.izq), altura(y.der)) + 1;
            x.h = Math.max(altura(x.izq), altura(x.der)) + 1;
            return x;
        }

        private NodoAVL rotIzq(NodoAVL x){
            NodoAVL y = x.der;
            NodoAVL T2 = y.izq;
            y.izq = x; x.der = T2;
            x.h = Math.max(altura(x.izq), altura(x.der)) + 1;
            y.h = Math.max(altura(y.izq), altura(y.der)) + 1;
            return y;
        }

        private NodoAVL insertarRec(NodoAVL n, int v){
            if (n == null) return new NodoAVL(v);
            if (v < n.v) n.izq = insertarRec(n.izq, v);
            else if (v > n.v) n.der = insertarRec(n.der, v);
            else return n; // no duplicados

            n.h = Math.max(altura(n.izq), altura(n.der)) + 1;
            int bf = balance(n);

            // Casos de rotación con registro del tipo
            if (bf > 1 && v < n.izq.v) { // LL
                rotacionesRealizadas.add("LL en " + n.v);
                return rotDer(n);
            }
            if (bf < -1 && v > n.der.v) { // RR
                rotacionesRealizadas.add("RR en " + n.v);
                return rotIzq(n);
            }
            if (bf > 1 && v > n.izq.v) { // LR
                rotacionesRealizadas.add("LR en " + n.v);
                n.izq = rotIzq(n.izq);
                return rotDer(n);
            }
            if (bf < -1 && v < n.der.v) { // RL
                rotacionesRealizadas.add("RL en " + n.v);
                n.der = rotDer(n.der);
                return rotIzq(n);
            }
            return n;
        }

        public List<Integer> enOrden(){
            List<Integer> r = new ArrayList<>(); enOrden(raiz, r); return r;
        }
        private void enOrden(NodoAVL n, List<Integer> r){
            if (n == null) return; enOrden(n.izq, r); r.add(n.v); enOrden(n.der, r);
        }
        // Complejidad: inserción O(log n) amortizada; rotaciones O(1) por inserción
    }

    /* =================== 6) BST: buscar, insertar y eliminar ===================== */
    static class BST {
        static class N { int v; N izq, der; N(int v){ this.v = v; } }
        N raiz;

        public void insertar(int v){ raiz = ins(raiz, v); }
        private N ins(N n, int v){
            if(n == null) return new N(v);
            if(v < n.v) n.izq = ins(n.izq, v);
            else if(v > n.v) n.der = ins(n.der, v);
            return n;
        }

        public boolean buscar(int v){ return buscarRec(raiz, v) != null; }
        private N buscarRec(N n, int v){
            if(n == null) return null;
            if(v == n.v) return n;
            return v < n.v ? buscarRec(n.izq, v) : buscarRec(n.der, v);
        }

        public void eliminar(int v){ raiz = del(raiz, v); }
        private N del(N n, int v){
            if(n == null) return null;
            if(v < n.v) n.izq = del(n.izq, v);
            else if(v > n.v) n.der = del(n.der, v);
            else {
                if(n.izq == null) return n.der;
                if(n.der == null) return n.izq;
                // dos hijos: sucesor (mínimo del subárbol derecho)
                N s = n.der; while(s.izq != null) s = s.izq;
                n.v = s.v;
                n.der = del(n.der, s.v);
            }
            return n;
        }

        public List<Integer> enOrden(){ List<Integer> r=new ArrayList<>(); en(raiz,r); return r; }
        private void en(N n,List<Integer> r){ if(n==null)return; en(n.izq,r); r.add(n.v); en(n.der,r); }
        // Complejidad promedio: buscar/insertar/eliminar O(log n). Peor caso (desbalanceado): O(n).
    }

    /* =================== 7) GRAFO: Dijkstra y BFS de ruta corta ================== */
    static class Grafo {
        static class Arista { String to; int w; Arista(String t,int w){this.to=t; this.w=w;} }
        private final Map<String, List<Arista>> adj = new HashMap<>();

        public void agregarVertice(String v){ adj.putIfAbsent(v, new ArrayList<>()); }
        public void agregarArista(String v1, String v2, int w){
            agregarVertice(v1); agregarVertice(v2);
            adj.get(v1).add(new Arista(v2, w));
            adj.get(v2).add(new Arista(v1, w)); // no dirigido para mapa de ciudades
        }

        public List<String> bfsRuta(String origen, String destino){
            // Ruta más corta en número de aristas (no ponderada)
            Map<String, String> prev = new HashMap<>();
            Queue<String> q = new ArrayDeque<>();
            Set<String> vis = new HashSet<>();
            q.add(origen); vis.add(origen);
            while(!q.isEmpty()){
                String u = q.poll();
                if(u.equals(destino)) break;
                for(Arista e: adj.getOrDefault(u, List.of())){
                    if(!vis.contains(e.to)){
                        vis.add(e.to); prev.put(e.to, u); q.add(e.to);
                    }
                }
            }
            return reconstruir(prev, origen, destino);
        }

        public static class ResultadoCamino {
            public final List<String> camino;
            public final Map<String,Integer> dist;
            ResultadoCamino(List<String> c, Map<String,Integer> d){camino=c; dist=d;}
        }

        public ResultadoCamino dijkstra(String origen, String destino){
            Map<String,Integer> dist = new HashMap<>();
            Map<String,String> prev = new HashMap<>();
            for(String v: adj.keySet()) dist.put(v, Integer.MAX_VALUE/4);
            dist.put(origen, 0);

            PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
            pq.add(origen);

            while(!pq.isEmpty()){
                String u = pq.poll();
                if(u.equals(destino)) break;
                for(Arista e: adj.getOrDefault(u, List.of())){
                    int nd = dist.get(u) + e.w;
                    if(nd < dist.get(e.to)){
                        dist.put(e.to, nd);
                        prev.put(e.to, u);
                        pq.remove(e.to);
                        pq.add(e.to);
                    }
                }
            }
            List<String> camino = reconstruir(prev, origen, destino);
            return new ResultadoCamino(camino, dist);
        }

        private List<String> reconstruir(Map<String,String> prev, String o, String d){
            LinkedList<String> path = new LinkedList<>();
            if(o.equals(d)){ path.add(o); return path; }
            String cur = d;
            if(!prev.containsKey(cur)) return List.of(); // sin camino
            while(cur != null){
                path.addFirst(cur);
                cur = prev.get(cur);
            }
            return path;
        }
        // Complejidad: BFS O(V+E). Dijkstra con PQ O((V+E) log V).
    }

    /* ========== 8) Complejidad: clasificación de operaciones pedidas ============= */
    static Map<String, String> complejidades() {
        Map<String,String> m = new LinkedHashMap<>();
        m.put("Búsqueda en BST (promedio)", "O(log n)"); // peor caso O(n)
        m.put("Inserción en HashMap (promedio)", "O(1)"); // peor caso O(n)
        m.put("Recorrido de grafo (BFS)", "O(V + E)");
        return m;
    }

    /* ============== Proyecto Integrador: Grafo + Pila con complejidad ============ */
    static class NavegadorCiudades {
        private final Grafo grafo;
        private final Deque<String> historial = new ArrayDeque<>(); // para deshacer pasos (pila)
        private String actual;

        NavegadorCiudades(Grafo g, String origen){
            this.grafo = g; this.actual = origen; historial.push(origen);
        }

        public List<String> irA(String destino){
            Grafo.ResultadoCamino rc = grafo.dijkstra(actual, destino);
            if(rc.camino.isEmpty()) return rc.camino;
            // Guardamos cada salto en historial para poder "Deshacer"
            for(int i=1;i<rc.camino.size();i++){
                historial.push(rc.camino.get(i));
            }
            actual = destino;
            return rc.camino;
        }

        public boolean deshacerPaso(){
            if(historial.size() <= 1) return false; // no deshacer el origen
            historial.pop(); // quita nodo actual
            actual = historial.peek();
            return true;
        }

        public String ciudadActual(){ return actual; }

        // Complejidad: irA usa Dijkstra O((V+E) log V); deshacerPaso O(1).
    }

    /* ================================ DEMOS ===================================== */
    public static void main(String[] args) {
        // 1) PILA: Editor Deshacer/Rehacer
        System.out.println("== PILA: Editor ==");
        EditorHistory ed = new EditorHistory();
        ed.type("Hola");
        ed.type("Hola mundo");
        ed.undo();
        ed.redo();
        System.out.println("Texto actual: " + ed.getText());

        // 2) PRIORITY QUEUE: Sistema de atención
        System.out.println("\n== PRIORITY QUEUE ==");
        CentroAtencion ca = new CentroAtencion();
        ca.nuevoTicket("Ana", 2);
        ca.nuevoTicket("Luis", 1);
        ca.nuevoTicket("Marta", 1);
        while(!ca.vacio()) System.out.println("Atendido: " + ca.atender());

        // 3) HASHMAP: Usuarios únicos
        System.out.println("\n== HASHMAP USUARIOS ==");
        UserRepo repo = new UserRepo();
        System.out.println("Insert Ana(1): " + repo.agregar(new Usuario(1,"Ana")));
        System.out.println("Insert Luis(2): " + repo.agregar(new Usuario(2,"Luis")));
        System.out.println("Insert Duplicado Ana(1): " + repo.agregar(new Usuario(1,"Ana")));
        System.out.println("Todos: " + repo.todos());

        // 4) ÁRBOL BINARIO: recorridos
        System.out.println("\n== ÁRBOL BINARIO: RECORRIDOS ==");
        ArbolBinario ab = new ArbolBinario();
        for(int v: new int[]{7,4,9,1,6,8,10}) ab.insertar(v);
        System.out.println("In-orden: " + ab.enOrden());
        System.out.println("Pre-orden: " + ab.preOrden());
        System.out.println("Post-orden: " + ab.postOrden());

        // 5) AVL: inserciones + reporte de rotaciones
        System.out.println("\n== AVL: ROTACIONES ==");
        AVL avl = new AVL();
        for(int v: new int[]{30, 20, 40, 10, 25, 22, 50, 5}) avl.insertar(v); // fuerza alguna LR/LL
        System.out.println("AVL in-orden: " + avl.enOrden());
        System.out.println("Rotaciones: " + avl.rotacionesRealizadas);

        // 6) BST: buscar / insertar / eliminar
        System.out.println("\n== BST ==");
        BST bst = new BST();
        for(int v: new int[]{8,3,10,1,6,14,4,7,13}) bst.insertar(v);
        System.out.println("Buscar 6: " + bst.buscar(6));
        System.out.println("In-orden antes de eliminar 3: " + bst.enOrden());
        bst.eliminar(3);
        System.out.println("In-orden después de eliminar 3: " + bst.enOrden());

        // 7) GRAFO: BFS y Dijkstra
        System.out.println("\n== GRAFO: Rutas ==");
        Grafo g = new Grafo();
        g.agregarArista("A","B",4);
        g.agregarArista("A","C",2);
        g.agregarArista("B","C",1);
        g.agregarArista("B","D",5);
        g.agregarArista("C","D",8);
        g.agregarArista("C","E",10);
        g.agregarArista("D","E",2);

        System.out.println("BFS ruta A->E: " + g.bfsRuta("A","E"));
        Grafo.ResultadoCamino rc = g.dijkstra("A","E");
        System.out.println("Dijkstra ruta A->E: " + rc.camino + " (dist=" + rc.dist.get("E") + ")");

        // 8) Complejidad
        System.out.println("\n== COMPLEJIDAD ==");
        complejidades().forEach((k,v) -> System.out.println(k + " -> " + v));

        // Proyecto integrador: Grafo + Pila
        System.out.println("\n== PROYECTO INTEGRADOR: Navegación con Deshacer ==");
        NavegadorCiudades nav = new NavegadorCiudades(g, "A");
        System.out.println("Ir a D: " + nav.irA("D"));
        System.out.println("Ciudad actual: " + nav.ciudadActual());
        System.out.println("Deshacer: " + nav.deshacerPaso() + " -> " + nav.ciudadActual());
        System.out.println("Ir a E: " + nav.irA("E"));
        System.out.println("Ciudad actual: " + nav.ciudadActual());
    }
}
