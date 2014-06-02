package Model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Model {

    String query = null;
    String bd = "2014mundial";
    String login = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/" + bd;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Boolean aux = false;
    int idioma;
    String peticion;

    public Model(int idioma, String peticion) {
        this.idioma = idioma;
        this.peticion = peticion;

    }

    public Connection creaConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("conecto correctamente");
        } catch (SQLException | ClassNotFoundException e) {
        }
        return conn;
    }

    public ResultSet query() {
        query = "";
        switch (peticion) {
            case "selecciones":
                query = Consultas(1);

                break;
            case "ciudades":
                query = Consultas(2);

                break;
            case "estadios":
                query = Consultas(3);
                break;
            case "noticias":
                query = Consultas(4);
                break;

            case "imagenes":
                query = Consultas(5);
                break;
            case "videos":
                query = Consultas(6);
                break;

            case "galeria":
                query = Consultas(7);
                break;

            case "calendario":
                query = Consultas(8);
                break;

            case "historias":
                query = Consultas(9);
                break;

            case "FotoEquipo":
                query = Consultas(10);
                break;

            case "Jugadores":
                query = Consultas(11);
                break;

//                 case "favoritos":
//                query = Consultas(12);
//                break;
            default:
                query = Consultas(12);
                break;

        }

        try {

            pst = creaConexion().prepareStatement(query);

            rs = pst.executeQuery();

        } catch (SQLException ex) {
            System.out.println("error XD");
            ex.printStackTrace();
        }

        return rs;
    }

    public void cerrarConexion() {
        try {
            System.out.println("CERRAR CONEXION OK");
            pst.close();
            conn.close();
        } catch (SQLException ex) {
        }

    }

    public String Consultas(int i) {
        String var = " ";
        switch (i) {

            case 1:
                if (this.idioma == 1) {
                    var = "SELECT s.idSeleccion, s.nombreIng, s.continenteIng,";

                } else {
                    var = "SELECT s.idSeleccion, s.nombreEs, s.continenteEs,";
                }
                var += "s.bandera, t.nombre, s.PJ, s.PG, s.PP, s.PE, s.GF, s.GC, s.Pts, s.participaciones, s.titulos, s.ranking FROM seleccion s, grupo g, TipoGrupo t" + " WHERE s.idSeleccion = g.idSeleccion AND g.idTipoGrupo = t.idTipoGrupo ORDER BY  s.idSeleccion ASC";
                break;

            case 2:

                if (this.idioma == 1) {
                    var = "Select idCiudad,nombreIng,urlImg,urlImg2,descripcionIng ";
                } else {
                    var = "Select idCiudad,nombreEsp,urlImg,urlImg2,descripcionEsp ";
                }
                var += "from ciudad";
                break;

            case 3:

                if (this.idioma == 1) {
                    var = "select e.idEstadio, e.nombreIng, e.año_construido, e.capacidad, e.urlImg, e.urlImg2, e.descripcionIng, c.nombreIng ";
                } else {
                    var = "select e.idEstadio, e.nombre, e.año_construido, e.capacidad, e.urlImg, e.urlImg2, e.descripcion, c.nombreEsp";
                }
                var += " from estadio as e, ciudad as c WHERE e.idCiudad = c.idCiudad";
                break;

            case 4:
                if (this.idioma == 1) {
                    var = "select idNoticia,titulo, img1,img2,fecha, noticia from noticia where idioma=1 order by idNoticia DESC LIMIT 10";
                } else {
                    var = "select idNoticia,titulo, img1,img2,fecha, noticia from noticia where idioma=2 order by idNoticia DESC LIMIT 10";
                }
                break;
            case 5:

                var = "select idFoto, titulo, img1, img2, fecha, comentario from foto  order by idFoto DESC LIMIT 10";

                break;

            case 6:
                if (this.idioma == 1) {

                    var = "select idVideo, titulo, img1, img2, urlvideo, fecha, comentario from video where idioma = 1 order by idVideo DESC LIMIT 10";
                } else {
                    var = "select idVideo, titulo, img1, img2, urlvideo, fecha, comentario from video where idioma = 2 order by idVideo DESC LIMIT 10";
                }

                break;

            case 7:
                if (this.idioma == 1) {
                    var = "SELECT f.idFoto, c.nombreIng, f.titulo, f.img1, f.img2, f.fecha, f.comentario "
                            + "FROM fotociudad AS f "
                            + "INNER JOIN ciudad AS c ON f.idCiudad = c.idCiudad where f.idioma=1 ";

                } else {
                    var = "SELECT f.idFoto, c.nombreEsp, f.titulo, f.img1, f.img2, f.fecha, f.comentario "
                            + "FROM fotociudad AS f "
                            + "INNER JOIN ciudad AS c ON f.idCiudad = c.idCiudad  where f.idioma= 2 ";

                }

                break;

            case 8:
                if (this.idioma == 1) {
                    var = "select * from calendarioING";

                } else {
                    var = "select * from calendarioes";

                }

                break;

            case 9:
                if (this.idioma == 1) {
                    var = "select "
                            + "idHistoria, "
                            + "titulo, "
                            + "titulo2, "
                            + "img1, "
                            + "img2, "
                            + "mascota, "
                            + "img, "
                            + "texto, "
                            + "ganador, "
                            + "lugar2, "
                            + "lugar3, "
                            + "lugar4, "
                            + "balonOro, "
                            + "botaOro, "
                            + "mejorJugador,  "
                            + "guanteOro, "
                            + "fairPlay "
                            + "from historiamundiales where idioma=1";

                } else {
                    var = "select "
                            + "idHistoria, "
                            + "titulo, "
                            + "titulo2, "
                            + "img1, "
                            + "img2, "
                            + "mascota, "
                            + "img, "
                            + "texto, "
                            + "ganador, "
                            + "lugar2, "
                            + "lugar3, "
                            + "lugar4, "
                            + "balonOro, "
                            + "botaOro, "
                            + "mejorJugador,  "
                            + "guanteOro, "
                            + "fairPlay "
                            + "from historiamundiales where idioma=2";

                }

                break;

            case 10:
                if (this.idioma == 2) {
                    var = "select se.idSeleccion, se.nombreEs, f.img1, f.img2, f.textoEsp, f.fecha from fotoequipo  as f inner join Seleccion as se on f.idSeleccion =se.idSeleccion";
                } else {
                    var = "select se.idSeleccion, se.nombreIng,  f.img1, f.img2, f.textoINg, f.fecha from fotoequipo  as f inner join Seleccion as se on f.idSeleccion = se.idSeleccion";
                }
                break;

            case 11:

                if (this.idioma == 2) {
                    var = " SELECT j.idJugador, s.nombreEs, j.nombre, j.apellidos, "
                            + " j.edad, j.posicionEsp, j.club "
                            + " FROM `jugador` as j inner join seleccion  "
                            + " as s on j.idSeleccion=s.idSeleccion	 ";
                } else {
                    var = " SELECT j.idJugador, s.nombreINg, j.nombre, j.apellidos, j.edad, j.posIng, j.club "
                            + " FROM  `jugador` AS j "
                            + " INNER JOIN seleccion AS s ON j.idSeleccion = s.idSeleccion ";
                }
                break;

            case 12:

                if (this.idioma == 1) {
                     var = "select idFavorito, idEquipo, titulo, img1, img2, descripcion, fecha  from Favoritos  where idioma=1 and  idEquipo in (" + this.peticion + ") order by idequipo";
                    System.out.println("Imprimiendo 1");
                } else {
                    System.out.println("Imprimiendo 2");
                    var = "select idFavorito, idEquipo, titulo, img1, img2, descripcion, fecha  from Favoritos  where idioma=2 and  idEquipo in (" + this.peticion + ") order by idequipo ";
                }
                break;

        }
        System.out.println("MI CONSUlTA " + var);
        return var;

    }

}
