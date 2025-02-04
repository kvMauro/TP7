package com.tp7;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tp7.dao.ISeguroDao;
import com.tp7.dao.SeguroDao;
import com.tp7.entidades.Seguro;
import com.tp7.entidades.TipoSeguro;

@WebServlet("/servletAgregarSeguro")
public class ServletAgregarSeguro extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Seguro seguro;
    private TipoSeguro tipo;
    private ISeguroDao sd = new SeguroDao();

    public ServletAgregarSeguro() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("btnAceptar") != null) {

            seguro = new Seguro();
            seguro.setDescripcion(request.getParameter("txtDescripcion"));
            tipo = new TipoSeguro();
            tipo.setIdTipo(Integer.parseInt(request.getParameter("tipo").toString()));
            seguro.setIdTipo(tipo);
            seguro.setCostoContratacion(Float.parseFloat(request.getParameter("txtCostoContratacion").toString()));
            seguro.setCostoAsegurado(Float.parseFloat(request.getParameter("txtCostoMaximo").toString()));

            boolean agregado = sd.agregarSeguro(seguro);

            // REQUEST DISPATCHER
            request.setAttribute("agregado", agregado);
            RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguros.jsp");
            rd.forward(request, response);
        }

    }

}
