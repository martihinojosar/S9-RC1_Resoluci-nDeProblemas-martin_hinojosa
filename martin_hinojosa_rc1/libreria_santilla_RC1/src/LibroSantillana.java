class LibroSantillana
{
    private String idLibro;
    private String titulo;
    private double precioCosto;
    private double precioVenta;
    private int cantidadStock;
    private int nivelEscolar;

    public LibroSantillana()
    {
    }

    public String getIdLibro()
    {
        return idLibro;
    }

    public void setIdLibro(String idLibro)
    {
        this.idLibro = idLibro;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public double getPrecioCosto()
    {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto)
    {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta()
    {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta)
    {
        this.precioVenta = precioVenta;
    }

    public int getCantidadStock()
    {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock)
    {
        this.cantidadStock = cantidadStock;
    }

    public int getNivelEscolar()
    {
        return nivelEscolar;
    }

    public void setNivelEscolar(int nivelEscolar)
    {
        this.nivelEscolar = nivelEscolar;
    }
}

class LibroInglesSantillana extends LibroSantillana
{
    private String nivelMCER;

    public LibroInglesSantillana()
    {
        super();
    }

    public String getNivelMCER()
    {
        return nivelMCER;
    }

    public void setNivelMCER(String nivelMCER)
    {
        this.nivelMCER = nivelMCER;
    }
}

class LibroMatematicaSantillana extends LibroSantillana
{
    private boolean incluyeFormulario;

    public LibroMatematicaSantillana()
    {
        super();
    }

    public boolean isIncluyeFormulario()
    {
        return incluyeFormulario;
    }

    public void setIncluyeFormulario(boolean incluyeFormulario)
    {
        this.incluyeFormulario = incluyeFormulario;
    }
}

class LibroArteSantillana extends LibroSantillana
{
    private String tipoCartulina;

    public LibroArteSantillana()
    {
        super();
    }

    public String getTipoCartulina()
    {
        return tipoCartulina;
    }

    public void setTipoCartulina(String tipoCartulina)
    {
        this.tipoCartulina = tipoCartulina;
    }
}

class LibroBiologiaSantillana extends LibroSantillana
{
    private boolean incluyeAnatomia3D;

    public LibroBiologiaSantillana()
    {
        super();
    }

    public boolean isIncluyeAnatomia3D()
    {
        return incluyeAnatomia3D;
    }

    public void setIncluyeAnatomia3D(boolean incluyeAnatomia3D)
    {
        this.incluyeAnatomia3D = incluyeAnatomia3D;
    }
}