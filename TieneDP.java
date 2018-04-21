package consultora;
import java.util.StringTokenizer;
public class TieneDP {
    private String numeroSucursal, claveProducto;
    
    public TieneDP(){
        this.numeroSucursal = "";
        this.claveProducto  = "";
    }
    public TieneDP(String datos){
        StringTokenizer st  = new StringTokenizer(datos, "_");
        this.numeroSucursal = st.nextToken();
        this.claveProducto  = st.nextToken();
    }
    
/* GETTERS */
    public String getNumeroSucursal() {
        return this.numeroSucursal;
    }
    public String getClaveProducto() {
        return this.claveProducto;
    }

/* SETTERS */
    public void setNumeroSucursal(String num) {
        this.numeroSucursal = num;
    }

    public void setClaveProducto(String clave) {
        this.claveProducto = clave;
    }
 
    @Override
    public String toString(){
        return this.numeroSucursal + "_" + this.claveProducto;
    }
    public String toStringSql(){
        return this.numeroSucursal + "," + this.claveProducto;
    }
}
