package lematizacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProyectoFinal extends javax.swing.JFrame {

    JFileChooser jfc_OpenFile;
    String FilePath;
    File Archivo;
    static String FileOriginal = "";
    static String Reading = FileOriginal;
    String noticiastfidf[] = null;

    private raiz raices;

    public ProyectoFinal() {
        initComponents();
         raices=new raiz();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_OpenFile = new javax.swing.JLabel();
        txt_File = new javax.swing.JTextField();
        btn_Shared = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        btn_Preprocesamiento = new javax.swing.JButton();
        raicesBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfidf = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        similitud = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1029, 681));
        setMinimumSize(new java.awt.Dimension(1029, 681));
        setPreferredSize(new java.awt.Dimension(1400, 750));
        setSize(new java.awt.Dimension(1029, 681));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_OpenFile.setFont(new java.awt.Font("Lucida Sans", 0, 20)); // NOI18N
        lbl_OpenFile.setText("OpenFile:");
        getContentPane().add(lbl_OpenFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, -1, -1));

        txt_File.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        txt_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FileActionPerformed(evt);
            }
        });
        getContentPane().add(txt_File, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 1150, 40));

        btn_Shared.setText("Shared");
        btn_Shared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SharedActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Shared, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 100, 40));

        txt_area.setColumns(20);
        txt_area.setRows(5);
        jScrollPane1.setViewportView(txt_area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 640, 530));

        btn_Preprocesamiento.setText("Preprocesamiento");
        btn_Preprocesamiento.setMaximumSize(new java.awt.Dimension(500, 22));
        btn_Preprocesamiento.setMinimumSize(new java.awt.Dimension(500, 22));
        btn_Preprocesamiento.setPreferredSize(new java.awt.Dimension(500, 22));
        btn_Preprocesamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PreprocesamientoMouseClicked(evt);
            }
        });
        btn_Preprocesamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PreprocesamientoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Preprocesamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 70));

        raicesBtn.setText("Raices");
        raicesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raicesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(raicesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 480, 70));

        jButton1.setText("Similitud Coseno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 430, 70));

        tfidf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tfidf);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 360, 530));

        similitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(similitud);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, 340, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void FileSave(String FileName) {
        try {
            FileWriter Texto = new FileWriter(FileName);
            Texto.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void btn_SharedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SharedActionPerformed
        jfc_OpenFile = new JFileChooser();
        jfc_OpenFile.showOpenDialog(null);
        File File = jfc_OpenFile.getSelectedFile();
        FilePath = File.getName();
        txt_File.setText(File.getAbsolutePath());
        try {
            FileReader Read = new FileReader(File);
            String Text = "";
            int Letters = Read.read();
            char Letter = '.';
            while (Letters != -1) {
                Letter = (char) Letters;
                Letters = Read.read();
                Text += Letter;
            }
            FileOriginal = Text;
            Read.close();
            //JOptionPane.showMessageDialog(null, "Cargado con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de carga");
        }
        FileOriginal = FileOriginal.replaceAll("\n", " \n");
        Reading = FileOriginal;
        txt_area.setText(Reading);
    }//GEN-LAST:event_btn_SharedActionPerformed

    public void tfIdf() {
        int i;

        String Tweets[] = noticiastfidf;
        String Temp[] = null;
        ArrayList<String> words = new ArrayList<String>();
        for (i = 0; i < Tweets.length; i++) {
            Temp = Tweets[i].split("\\s"); //separa las palabras de cada tweet y las guarda en temp
            for (int j = 0; j < Temp.length; j++) {
                if (!(Temp[j].isEmpty())) {
                    words.add(Temp[j]); //guarda palabra por palabra en el arraylist
                }
            }
        }
        for (i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {//busca en el arraylist de palabras aquellas que estan repetidas
                    words.remove(j);		//las elimina si encuentra repetidas
                    j--;
                    //creo que esto sirve para "construir la tabla" y comparar la busqueda
                }
            }
        }
        int Matriz[][] = new int[words.size()][Tweets.length];//inicializarla con 0 indicando que no se encuentran las palabras

        for (i = 0; i < words.size(); i++) {//recorre lista de palabras
            for (int j = 0; j < Tweets.length; j++) {//recorre los tweets
                Temp = Tweets[j].split("\\s");	//separa por palabras cada tweet
                for (int k = 0; k < Temp.length; k++) {//recorre las palabras del tweet
                    if (words.get(i).equals(Temp[k])) {//si la palabra a comparar de la lista se encuentra en las palabras del tweet
                        int cont = Matriz[i][j];
                        Matriz[i][j] = (Matriz[i][j] + 1);//supongo que se indica en la tabla que si se encuentra en ese documento o tweet
                    }
                }
            }
        }
        //imprimir matriz
        for (int x = 0; x < words.size(); x++) {
            //System.out.print("|");
            for (int y = 0; y < Tweets.length; y++) {
                //System.out.print (Matriz[x][y]);
                if (y != Tweets.length - 1) {
                    System.out.print("\t");
                }
            }
            //System.out.println("|");
        }
        //Metodo para consultar una busqueda utilizando directamente la tabla es
        //Temp=busqueda.split("\\s");//se separa la busqueda por palabras
        //podria discriminarse y de igual manera eliminar las repetidas
        int contP = 0;
        int aux;
        String Relevancia = "";

        for (int j = 0; j < Tweets.length; j++) {
            contP = 0;
            for (i = 0; i < Temp.length; i++) {//recorre las palabras de la busqueda
                aux = words.indexOf(Temp[i]);//consulta que la palabra de la busqueda este en la lista de palabras, si esta devuelve el indice correcto
                if (aux >= 0) {//si la encuentra entonces devuelve un numero igual o mayor a 0, hace lo siguiente
                    //si no la encuentra significa que no está en ninguno de los documentos, pues la lista es de solo palabras que sí estan en los documentos
                    if (Matriz[aux][j] == 1) {//si la i-esima palabra se encuentra en el j-esimo tweet
                        contP++;//contador de palabras encontradas
                        //System.out.println("Entra");
                    }
                }
            }//se va a la siguiente palabra de la busqueda
            if (contP == 0) {//si el contador de palabras encontradas en el documento es igual a cero
                //System.out.println("No Relevante\n");//se contempla como un documento no relevante
                Relevancia = "No Relevante";
            } else if (contP == Temp.length) {//si el contador de palabras encontradas en el documento es igual a la cantidad de palabras en la busqueda
                //System.out.println("Relevante\n");//se contempla como un documento relevant
                Relevancia = "Relevante";
            } else if (contP > 0) {//si el contador de palabras encontradas tiene al menos 1 entonces
                //System.out.println("Menos Relevante\n");//se contempla como un documento menos relevante
                Relevancia = "Menos Relevante";
            }
            //Data[0][(j+1)]=Relevancia;
        }
        /////////////////////////llenado de tabla 1////////////////////
        String Data1[][] = new String[(words.size() + 1)][(Tweets.length + 1)];//Contenido de la tabla (Traspazo de "Matriz")
        String Columnas1[] = new String[(Tweets.length + 1)];//Titulos de los documentos
        Columnas1[0] = "Palabras";//Celda independiente del llenado
        Data1[0][0] = "Cantidad de Palabras";//Celda independiente del llenado
        for (int k = 1; k < (Tweets.length + 1); k++) {
            Columnas1[k] = "Tweet " + k;//Nombre de Tweet x
        }
        for (int k = 1; k < (Tweets.length + 1); k++) {
            int CantPal = 0;//Contador de palarbas por documento
            for (int l = 0; l < words.size(); l++) {//Recorre la cantidad de palabras totales de todos los documentos sin repeticion
                CantPal = CantPal + Matriz[l][(k - 1)];//agrega las palabras del documento
            }
            Data1[0][(k)] = "" + CantPal;//Guarda la cantidad de palabras por tweet
        }
        for (int p = 0; p < words.size(); p++) {
            Data1[(p + 1)][0] = words.get(p);//Llenamos la columna de las palabras
        }
        for (int j = 0; j < words.size(); j++) {
            for (int k = 0; k < Tweets.length; k++) {
                Data1[(j + 1)][(k + 1)] = String.valueOf(Matriz[j][k]);//Llenamos la tabla empezando en (1,7), para dejar espacio para la fila de "Relevancia" y la columna de las "Palabras"
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////Codigo nuevo para practica TF-IDF//////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////

        //////////////Matriz a Matriz2 (Para obtener los valores de frecuencia.)
        double Matriz2[][] = new double[words.size()][Tweets.length];//Se declara una matriZ igual a la inicial, pero en formato Double(por el punto decimal)
        for (int w = 0; w < words.size(); w++) {//Cantidad de palabras en total de los documentos
            for (int t = 0; t < Tweets.length; t++) {//Cantidad de documentos (Tweets)
                if (Matriz[w][t] > 0) {//Condicional para la frecuencia
                    //Matriz2[w][t]=(Matriz[w][t]+1);
                    Matriz2[w][t] = (Math.log((Matriz[w][t])) / Math.log(2)) + 1;//Obtencion de las frecuencias
                } else {///Caso de Valor de repeticion de palabra = 0
                    Matriz2[w][t] = 0;
                }
            }
        }
        ////////////////////////Se genera una nueva tabla para guardar la informacion de la nueva matriz "Matriz2"
        /////////////////////////llenado de tabla 2////////////////////
        String Data2[][] = new String[(words.size() + 1)][(Tweets.length + 1)];//Contenido de la tabla (Traspazo de "Matriz")
        String Columnas2[] = new String[(Tweets.length + 1)];//Titulos de los documentos
        Columnas2[0] = "Palabras";//Celda independiente del llenado
        Data2[0][0] = "Cantidad de Palabras";//Celda independiente del llenado
        for (int k = 1; k < (Tweets.length + 1); k++) {
            Columnas2[k] = "Tweet " + k;//Nombre de Tweet x
        }
        for (int k = 1; k < (Tweets.length + 1); k++) {
            int CantPal = 0;//Contador de palarbas por documento
            for (int l = 0; l < words.size(); l++) {//Recorre la cantidad de palabras totales de todos los documentos sin repeticion
                CantPal = CantPal + Matriz[l][(k - 1)];//agrega las palabras del documento
            }
            Data2[0][(k)] = "" + CantPal;//Guarda la cantidad de palabras por tweet
        }
        for (int p = 0; p < words.size(); p++) {
            Data2[(p + 1)][0] = words.get(p);//Llenamos la columna de las palabras
        }
        for (int j = 0; j < words.size(); j++) {
            for (int k = 0; k < Tweets.length; k++) {
                Data2[(j + 1)][(k + 1)] = String.valueOf(Matriz2[j][k]);//Llenamos la tabla empezando en (1,7), para dejar espacio para la fila de "Relevancia" y la columna de las "Palabras"
            }
        }

        ////////////////////////////////////////////Matriz3
        ///////////////Obtencion de la cantidad de documentos con X palabra
        int ni[] = new int[words.size()];
        for (int w = 0; w < words.size(); w++) {
            for (int t = 0; t < Tweets.length; t++) {
                if (Matriz[w][t] > 0) {
                    ni[w] = ni[w] + 1;
                }
            }
            //System.out.println("ni="+ni[w]+" palabra:"+words.get(w));
        }

        double IDF[] = new double[words.size()];
        double Matriz3[][] = new double[words.size()][Tweets.length];//Se declara una matriZ igual a la inicial, pero en formato Double(por el punto decimal)

        //JOptionPane.showMessageDialog(null, "valor de Tweets.length = "+Tweets.length+ "ni = 2"+Math.log(Tweets.length/2));
        for (int w = 0; w < words.size(); w++) {//Cantidad de palabras en total de los documentosha
            for (int t = 0; t < Tweets.length; t++) {//Cantidad de documentos (Tweets)
                if (Matriz[w][t] > 0) {//Condicional para la frecuencia
                    //Matriz2[w][t]=(Matriz[w][t]+1);

                    //Matriz2[w][t]=(Math.log((Matriz[w][t])) / Math.log(2))+1;//Obtencion de las frecuencias
                    //Logaritmo en base 2 de num = Math.log(numero de documentos/la suma de los documentos donde sale la palabra)
                    //Todas coinciden, solo la division de 4/3 deberia dar 0.415, pero da 0
                    IDF[w] = (Math.log((float) Tweets.length / ni[w]) / Math.log(2));

                } else {///Caso de Valor de repeticion de palabra = 0
                    Matriz3[w][t] = 0;
                }
            }
            //System.out.println("IDF:"+IDF[w]+" palabra:"+words.get(w));
        }

        /////////////////////////llenado de tabla 3////////////////////
        String Data3[][] = new String[words.size()][(3)];//Contenido de la tabla (Traspazo de "Matriz")
        String Columnas3[] = new String[3];//Titulos de los documentos
        Columnas3[0] = "Palabras";//Celda independiente del llenado
        Columnas3[1] = "ni";
        Columnas3[2] = "IDFi=log(N/ni)";
        for (int j = 0; j < words.size(); j++) {
            Data3[(j)][(0)] = words.get(j);
            Data3[(j)][(1)] = "" + ni[j];
            Data3[(j)][(2)] = "" + IDF[j];
        }

        /////////////////////////llenado de tabla 4////////////////////
        double Matriz4[][] = new double[words.size()][Tweets.length];//Se declara una matriZ igual a la inicial, pero en formato Double(por el punto decimal)
        for (int w = 0; w < words.size(); w++) {//Cantidad de palabras en total de los documentos
            for (int t = 0; t < Tweets.length; t++) {//Cantidad de documentos (Tweets)
                Matriz4[w][t] = (Matriz2[w][t] * IDF[w]);
            }
        }
        String Data4[][] = new String[(words.size() + 1)][(Tweets.length + 1)];//Contenido de la tabla (Traspazo de "Matriz")
        String Columnas4[] = new String[(Tweets.length + 1)];//Titulos de los documentos
        Columnas4[0] = "Palabras";//Celda independiente del llenado
        Data4[0][0] = "Cantidad de Palabras";//Celda independiente del llenado
        for (int k = 1; k < (Tweets.length + 1); k++) {
            Columnas4[k] = "Noticia " + k;//Nombre de Tweet x
        }
        for (int k = 1; k < (Tweets.length + 1); k++) {
            int CantPal = 0;//Contador de palarbas por documento
            for (int l = 0; l < words.size(); l++) {//Recorre la cantidad de palabras totales de todos los documentos sin repeticion
                CantPal = CantPal + Matriz[l][(k - 1)];//agrega las palabras del documento
            }
            Data4[0][(k)] = "" + CantPal;//Guarda la cantidad de palabras por tweet
        }
        for (int p = 0; p < words.size(); p++) {
            Data4[(p + 1)][0] = words.get(p);//Llenamos la columna de las palabras
        }
        for (int j = 0; j < words.size(); j++) {
            for (int k = 0; k < Tweets.length; k++) {
                Data4[(j + 1)][(k + 1)] = String.valueOf(Matriz4[j][k]);//Llenamos la tabla empezando en (1,7), para dejar espacio para la fila de "Relevancia" y la columna de las "Palabras"
            }
        }

        double sumatoria[][] = new double[(noticiastfidf.length)][1];
        double suma = 0.0;
        int cont = 0;
        System.out.println("");
        for (int j = 1; j <= noticiastfidf.length; j++) {
            for (int k = 1; k <= words.size(); k++) {
                //System.out.println(j + "  " + k);
                
                suma = suma + Double.valueOf(Data4[k][j]);
            }
            sumatoria[cont][0] = suma/Double.valueOf((Data4[0][(cont+1)]));
            System.out.println(suma);
            suma = 0.0;
            cont++;
        }
        int aux999 = 1;
        for(int j=0;j<sumatoria.length;j++){
            for(int k=1;k<sumatoria.length;k++){
                System.err.println(aux999 +": "+ similitud(sumatoria[j][0], sumatoria[k][0]));
                aux999++;
            }
        }
        
        for (int j = 0; j < sumatoria.length; j++) {
            System.out.println("Suma total de la noticia: " + (j+1) + ": " + sumatoria[j][0]);
        }
        
        String TablaSililitud[][] = new String[sumatoria.length][sumatoria.length+1];
        for(int n1=0;n1<sumatoria.length;n1++){
            for(int n2=1;n2<=sumatoria.length;n2++){
                TablaSililitud[(n1)][(n2)]= "" + similitud(sumatoria[n1][0], sumatoria[n2-1][0]);
            }
        }
        
        String ColumnasSimilitud[]= new String[(sumatoria.length+1)];//Titulos de los documentos
        ColumnasSimilitud[0]="VS";//Celda independiente del llenado
        for (int k=1;k<(sumatoria.length+1);k++){
            ColumnasSimilitud[k]="Noticia "+k;//Nombre de Tweet x
            TablaSililitud[k-1][0]="Noticia "+k;
        }
        
        for(int n1=1;n1<=sumatoria.length;n1++){
                TablaSililitud[n1-1][n1]=""+1;
            }
        
        similitud.setModel(new DefaultTableModel(TablaSililitud, ColumnasSimilitud));

        tfidf.setModel(new DefaultTableModel(Data4, Columnas4));

    }

    public void signos() {
        String Tweet = Reading;

        Tweet = Tweet.replaceAll("(?![/<>])\\p{Punct}", "");

        Tweet = Tweet.replaceAll("…", "");
        Tweet = Tweet.replaceAll("…", "");
        Tweet = Tweet.replaceAll("“", "");
        Tweet = Tweet.replaceAll("”", "");
        Tweet = Tweet.replaceAll("–", "");
        Reading = Tweet;
        txt_area.setText(Tweet);
    }
    
    public double similitud(double x, double y){
    double[] vectorA = {1,x};
    double[] vectorB = {y,1};
    double dotProduct = 0.0;
    double normA = 0.0;
    double normB = 0.0;
    for (int i = 0; i < vectorA.length; i++) {
        dotProduct += vectorA[i] * vectorB[i];
        normA += Math.pow(vectorA[i], 2);
        normB += Math.pow(vectorB[i], 2);
    }   
    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    
}

    public void usuarios() {
        String Tweet = " " + Reading;
        String Sustitucion = "$user";
        int Arroba = 0, Espacio = 0;
        for (int i = 0; i < Tweet.length(); i++) {
            if (Tweet.charAt(i) == '@') {
                Arroba = i;
            }
            if (Tweet.charAt(i) == ' ') {
                Espacio = i;
            }
            if (Arroba < Espacio) {
                if (Arroba != 0 && Espacio != 0) {
                    Tweet = Tweet.substring(0, Arroba) + Sustitucion + Tweet.substring(Espacio, Tweet.length());
                    i = i - (Espacio - Arroba) + Sustitucion.length();
                    Arroba = Espacio = 0;
                }
            }
        }

        txt_area.setText(Tweet.substring(1, Tweet.length()));
        Reading = Tweet.substring(1, Tweet.length());
    }

    public void hashtag() {
        String Tweet = " " + Reading;
        String Sustitucion = "$ht";
        int Arroba = 0, Espacio = 0;
        for (int i = 0; i < Tweet.length(); i++) {
            if (Tweet.charAt(i) == '#') {
                Arroba = i;
            }
            if (Tweet.charAt(i) == ' ') {
                Espacio = i;
            }
            if (Arroba < Espacio) {
                if (Arroba != 0 && Espacio != 0) {
                    Tweet = Tweet.substring(0, Arroba) + Sustitucion + Tweet.substring(Espacio, Tweet.length());
                    i = i - (Espacio - Arroba) + Sustitucion.length();
                    Arroba = Espacio = 0;
                }
            }
        }
        txt_area.setText(Tweet.substring(1, Tweet.length()));
        Reading = Tweet.substring(1, Tweet.length());
    }

    public void emoticones() {
        String Tweet = " " + Reading;
        Tweet = Tweet.replaceAll(":/", "DISGUSTO");
        Tweet = Tweet.replaceAll("ʘ‿ʘ", "CARA INOCENTE");
        Tweet = Tweet.replaceAll("XD", "CARCAJADA");
        Tweet = Tweet.replaceAll("👌", "HAND OK");
        Tweet = Tweet.replaceAll("🔫", "GUN");
        Tweet = Tweet.replaceAll("👽", "ALIEN");
        Tweet = Tweet.replaceAll("🐶", "DOG");
        Tweet = Tweet.replaceAll("😭", "SAD");
        Tweet = Tweet.replaceAll("😉", "GUIÑO");
        Tweet = Tweet.replaceAll("😍", "LOVE EYES");
        Tweet = Tweet.replaceAll("😁", "SMILE");
        Tweet = Tweet.replaceAll("🎤", "MICROFONO");
        Tweet = Tweet.replaceAll("♫", "NOTA");
        Tweet = Tweet.replaceAll("✔️", "GOOD");
        Tweet = Tweet.replaceAll("🙏", "HANDS");
        Tweet = Tweet.replaceAll("😝", "LENGUA FUERA");
        Tweet = Tweet.replaceAll("😏", "SEXY");
        Tweet = Tweet.replaceAll("❤️", "HEART");
        Tweet = Tweet.replaceAll("😃", "SMILE");
        Tweet = Tweet.replaceAll("💋", "BESO");
        Tweet = Tweet.replaceAll("►", "FLECHA");
        Tweet = Tweet.replaceAll("❤️", "HEART WHITE");
        Tweet = Tweet.replaceAll("😆", "CARCAJADA");
        Tweet = Tweet.replaceAll("😔", "SAD");
        Tweet = Tweet.replaceAll("♥", "HEART");
        txt_area.setText(Tweet.substring(1, Tweet.length()));
        Reading = Tweet.substring(1, Tweet.length());
    }

    public void PalCerradas() {
        //JOptionPane.showMessageDialog(null, "Palabras cerradas");
        String Archivo = Reading;
        ////////Lista de palabras cerradas
        String PalabrasCerradas = "a\n"
                + "acá\n"
                + "ahí\n"
                + "ajena\n"
                + "ajeno\n"
                + "ajenas\n"
                + "ajenos\n"
                + "al\n"
                + "algo\n"
                + "algún\n"
                + "alguna\n"
                + "alguno\n"
                + "algunas\n"
                + "algunos\n"
                + "allá\n"
                + "allí\n"
                + "ambos\n"
                + "ante\n"
                + "antes\n"
                + "aquel\n"
                + "aquella\n"
                + "aquello\n"
                + "aquellas\n"
                + "aquellos\n"
                + "aquí\n"
                + "arriba\n"
                + "así\n"
                + "atrás\n"
                + "aun\n"
                + "aunque\n"
                + "bajo\n"
                + "bastante\n"
                + "bien\n"
                + "cabe\n"
                + "cada\n"
                + "casi\n"
                + "cierto\n"
                + "cierta\n"
                + "ciertos\n"
                + "ciertas\n"
                + "como\n"
                + "con\n"
                + "conmigo\n"
                + "conseguimos\n"
                + "conseguir\n"
                + "consigo\n"
                + "consigue\n"
                + "consiguen\n"
                + "consigues\n"
                + "contigo\n"
                + "contra\n"
                + "cual\n"
                + "cuales\n"
                + "cualquier\n"
                + "cualquiera\n"
                + "cualquieras\n"
                + "cuan\n"
                + "cuando\n"
                + "cuanto\n"
                + "cuanta\n"
                + "cuantos\n"
                + "cuantas\n"
                + "de\n"
                + "dejar\n"
                + "del\n"
                + "demás\n"
                + "demasiada\n"
                + "demasiado\n"
                + "demasiadas\n"
                + "demasiados\n"
                + "dentro\n"
                + "desde\n"
                + "donde\n"
                + "dos\n"
                + "el\n"
                + "él\n"
                + "ella\n"
                + "ello\n"
                + "ellas\n"
                + "ellos\n"
                + "empleáis\n"
                + "emplean\n"
                + "emplear\n"
                + "empleas\n"
                + "empleo\n"
                + "en\n"
                + "encima\n"
                + "entonces\n"
                + "entre\n"
                + "era\n"
                + "eras\n"
                + "eramos\n"
                + "eran\n"
                + "eres\n"
                + "es\n"
                + "esa\n"
                + "ese\n"
                + "eso\n"
                + "esas\n"
                + "esos\n"
                + "esta\n"
                + "estas\n"
                + "estaba\n"
                + "estado\n"
                + "estáis\n"
                + "estamos\n"
                + "están\n"
                + "estar\n"
                + "este\n"
                + "esto\n"
                + "estos\n"
                + "estoy\n"
                + "etc\n"
                + "fin\n"
                + "fue\n"
                + "fueron\n"
                + "fui\n"
                + "fuimos\n"
                + "gueno\n"
                + "ha\n"
                + "hace\n"
                + "haces\n"
                + "hacéis\n"
                + "hacemos\n"
                + "hacen\n"
                + "hacer\n"
                + "hacia\n"
                + "hago\n"
                + "hasta\n"
                + "incluso\n"
                + "intenta\n"
                + "intentas\n"
                + "intentáis\n"
                + "intentamos\n"
                + "intentan\n"
                + "intentar\n"
                + "intento\n"
                + "ir\n"
                + "jamás\n"
                + "junto\n"
                + "juntos\n"
                + "la\n"
                + "lo\n"
                + "las\n"
                + "los\n"
                + "largo\n"
                + "más\n"
                + "me\n"
                + "menos\n"
                + "mi\n"
                + "mis\n"
                + "mía\n"
                + "mías\n"
                + "mientras\n"
                + "mío\n"
                + "míos\n"
                + "misma\n"
                + "mismo\n"
                + "mismas\n"
                + "mismos\n"
                + "modo\n"
                + "mucha\n"
                + "muchas\n"
                + "muchísima\n"
                + "muchísimo\n"
                + "muchísimas\n"
                + "muchísimos\n"
                + "mucho\n"
                + "muchos\n"
                + "muy\n"
                + "nada\n"
                + "ni\n"
                + "ningún\n"
                + "ninguna\n"
                + "nignuno\n"
                + "ningunas\n"
                + "ningunos\n"
                + "no\n"
                + "nos\n"
                + "nosotras\n"
                + "nosotros\n"
                + "nuestra\n"
                + "nuestro\n"
                + "nuestras\n"
                + "nuestros\n"
                + "nunca\n"
                + "os\n"
                + "otra\n"
                + "otro\n"
                + "otras\n"
                + "otros\n"
                + "para\n"
                + "parecer\n"
                + "pero\n"
                + "poca\n"
                + "poco\n"
                + "pocas\n"
                + "pocos\n"
                + "podéis\n"
                + "podemos\n"
                + "poder\n"
                + "podría\n"
                + "podrías\n"
                + "podríais\n"
                + "podríamos\n"
                + "podrían\n"
                + "por\n"
                + "por qué\n"
                + "porque\n"
                + "primero\n"
                + "puede\n"
                + "pueden\n"
                + "puedo\n"
                + "pues\n"
                + "que\n"
                + "qué\n"
                + "querer\n"
                + "quién\n"
                + "quiénes\n"
                + "quienesquiera\n"
                + "quienquiera\n"
                + "quizá\n"
                + "quizá\n"
                + "sabe\n"
                + "sabes\n"
                + "saben\n"
                + "sabéis\n"
                + "sabemos\n"
                + "saber\n"
                + "se\n"
                + "según\n"
                + "ser\n"
                + "si\n"
                + "sí\n"
                + "siempre\n"
                + "siendo\n"
                + "sin\n"
                + "sino\n"
                + "so\n"
                + "sobre\n"
                + "sois\n"
                + "solamente\n"
                + "solo\n"
                + "sólo\n"
                + "somos\n"
                + "soy\n"
                + "sr\n"
                + "sra\n"
                + "sres\n"
                + "sta\n"
                + "su\n"
                + "sus\n"
                + "suya\n"
                + "suyo\n"
                + "suyas\n"
                + "suyos\n"
                + "tal\n"
                + "tales\n"
                + "también\n"
                + "tampoco\n"
                + "tan\n"
                + "tanta\n"
                + "tanto\n"
                + "tantas\n"
                + "tantos\n"
                + "te\n"
                + "tenéis\n"
                + "tenemos\n"
                + "tener\n"
                + "tengo\n"
                + "ti\n"
                + "tiempo\n"
                + "tiene\n"
                + "tienen\n"
                + "toda\n"
                + "todo\n"
                + "todas\n"
                + "todos\n"
                + "tomar\n"
                + "trabaja\n"
                + "trabajo\n"
                + "trabajáis\n"
                + "trabajamos\n"
                + "trabajan\n"
                + "trabajar\n"
                + "trabajas\n"
                + "tras\n"
                + "tú\n"
                + "tu\n"
                + "tus\n"
                + "tuya\n"
                + "tuyo\n"
                + "tuyas\n"
                + "tuyos\n"
                + "último\n"
                + "ultimo\n"
                + "un\n"
                + "una\n"
                + "uno\n"
                + "unas\n"
                + "unos\n"
                + "usa\n"
                + "usas\n"
                + "usáis\n"
                + "usamos\n"
                + "usan\n"
                + "usar\n"
                + "uso\n"
                + "usted\n"
                + "ustedes\n"
                + "va\n"
                + "van\n"
                + "vais\n"
                + "valor\n"
                + "vamos\n"
                + "varias\n"
                + "varios\n"
                + "vaya\n"
                + "verdadera\n"
                + "vosotras\n"
                + "vosotros\n"
                + "voy\n"
                + "vuestra\n"
                + "vuestro\n"
                + "vuestras\n"
                + "vuestros\n"
                + "y\n"
                + "ya\n"
                + "yo";
        //////////Fin de palabras cerradas
        String NvoString = Archivo;
        String PalCerr[] = PalabrasCerradas.split("\n");
        String Palabras[] = Archivo.split(" ");
        for (int i = 0; i < Palabras.length; i++) {
            for (int j = 0; j < PalCerr.length; j++) {
                if ((Palabras[i].equals(PalCerr[j]))) {
                    Palabras[i] = "";
                }
            }
        }
        //System.out.println(NvoString);
        Reading = String.join(" ", Palabras);
    }

    public void minusculas() {
        String aux = Reading.toLowerCase();
        txt_area.setText(aux);
        Reading = aux;
    }

    public void numeros() {
        String noNumeros = Reading;

        noNumeros = noNumeros.replace("0", "");
        noNumeros = noNumeros.replace("1", "");
        noNumeros = noNumeros.replace("2", "");
        noNumeros = noNumeros.replace("3", "");
        noNumeros = noNumeros.replace("4", "");
        noNumeros = noNumeros.replace("5", "");
        noNumeros = noNumeros.replace("6", "");
        noNumeros = noNumeros.replace("7", "");
        noNumeros = noNumeros.replace("8", "");
        noNumeros = noNumeros.replace("9", "");

        Reading = noNumeros;
    }


    private void txt_FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FileActionPerformed
    public void Preprocesamiento() {
        minusculas();
        signos();
        PalCerradas();
        Acentos();
        numeros();
        
        
        Reading = Reading.replaceAll("    ", " ");
        Reading = Reading.replaceAll("   ", " ");
        Reading = Reading.replaceAll("  ", " ");
        txt_area.setText(Reading);
    }

    public void Acentos() {
        String noticia = Reading;
        final String ORIGINAL = "ÁáÉéÍíÓóÚúÑñÜü";
        final String REEMPLAZO = "AaEeIiOoUuNnUu";

        if (noticia == null) {
            JOptionPane.showInputDialog(null, "Error en acentos");
        }
        char[] array = noticia.toCharArray();
        for (int indice = 0; indice < array.length; indice++) {
            int pos = ORIGINAL.indexOf(array[indice]);
            if (pos > -1) {
                array[indice] = REEMPLAZO.charAt(pos);
            }
        }
        Reading = new String(array);
        txt_area.setText(Reading);
    }
    private void btn_PreprocesamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PreprocesamientoMouseClicked

    }//GEN-LAST:event_btn_PreprocesamientoMouseClicked

    private void btn_PreprocesamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PreprocesamientoActionPerformed
        Preprocesamiento();
    }//GEN-LAST:event_btn_PreprocesamientoActionPerformed

    private void raicesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raicesBtnActionPerformed
        raiz();
    }//GEN-LAST:event_raicesBtnActionPerformed

    public void raiz() {
        int i,j;
        String noticias[]=txt_area.getText().split("</cuerpo>");
        String Temp[] = null;
        ArrayList<String> raicesw = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<String>();   
        
        txt_area.setText("");
        
        for(i=0;i<noticias.length;i++){//PRIMERO OBTENGO LA LISTA DE PALABRAS DE LA NOTICIA         
            words.clear();
            raicesw.clear();
            
            Temp = noticias[i].split("\\s"); //separa las palabras de cada twit y las guarda en temp
            
            System.out.println("hola");
            
            for(j=0;j<Temp.length;j++){
                if (!(Temp[j].isEmpty())){
                    words.add(Temp[j]); //guarda palabra por palabra en el arraylist
                }
            }
            
            for(int k=0;k<words.size();k++){
                for(j=k+1;j<words.size();j++){ 
                    if(words.get(k).equals(words.get(j))){//busca en el arraylist de palabras aquellas que estan repetidas
                        words.remove(j);		//las elimina si encuentra repetidas
                        j--;
                    }
                }
            }//en words tenemos las palabras sin repetir    
            System.out.println("/////////////////////////////");
            for(int p=0;p<words.size();p++){
                System.out.println(words.get(p));
            }
            //CON LA LISTA DE PALABRAS DE LA NOTICIA OBTENGO LAS RAICES
            raicesw=raices.obtenerRaiz(words);
            String str = raicesw.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
            txt_area.setText(txt_area.getText()+noticias[i]+"\n Raices: "+str);
            str="";
  
        }
    }
    
    public void noti() {
        int i, j;
        String noticias[] = txt_area.getText().split("</cuerpo>");
        String Temp[] = null;
        ArrayList<String> raicesw = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<String>();
        for (i = 0; i < noticias.length; i++) {//PRIMERO OBTENGO LA LISTA DE PALABRAS DE LA NOTICIA
            words.clear();
            Temp = noticias[i].split("\\s"); //separa las palabras de cada twit y las guarda en temp
            for (j = 0; j < Temp.length; j++) {
                words.add(Temp[j]); //guarda palabra por palabra en el arraylist
            }
            for (i = 0; i < words.size(); i++) {
                for (j = i + 1; j < words.size(); j++) {
                    if (words.get(i).equals(words.get(j))) {//busca en el arraylist de palabras aquellas que estan repetidas
                        words.remove(j);		//las elimina si encuentra repetidas
                        j--;
                        //creo que esto sirve para "construir la tabla" y comparar la busqueda
                    }
                }
            }//en words tenemos las palabras sin repetir
            //CON LA LISTA DE PALABRAS DE LA NOTICIA OBTENGO LAS RAICES
            //raicesw=raices.obtenerRaiz(words);
            //txt_area=
            String Temp2[] = new String[(noticias.length - 1)];
            for (int m = 0; m < (noticias.length - 1); m++) {
                Temp2[m] = noticias[m];
            }
            noticias = Temp2;
            noticiastfidf = noticias;
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Preprocesamiento();
        noti();
        tfIdf();

    }//GEN-LAST:event_jButton1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProyectoFinal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Preprocesamiento;
    private javax.swing.JButton btn_Shared;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_OpenFile;
    private javax.swing.JButton raicesBtn;
    private javax.swing.JTable similitud;
    private javax.swing.JTable tfidf;
    private javax.swing.JTextField txt_File;
    private javax.swing.JTextArea txt_area;
    // End of variables declaration//GEN-END:variables
}
