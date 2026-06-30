/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import br.com.projetowebfinal.util.ConnectionFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;


/**
 *
 * @author Anderson
 */
public class RelatorioImovel extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        JRResultSetDataSource jrRS = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.createStatement();
            //String sql = "SELECT * FROM administrativo.pessoa p WHERE p.tipo_pessoa = '" + tipoPessoa + "'";
            String sql = "select * from administrativo.movimentacao;";
            rs = stmt.executeQuery(sql);
            jrRS = new JRResultSetDataSource(rs);
        } catch (Exception e) {
            System.out.println("Erro DB: " + e.getMessage());
        }
        byte[] bytes = null;
        try {
            URL url = this.getClass().getClassLoader().getResource("/relatorios/clienteimovel.jasper");
            System.out.println("URL: " + url);
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject(url);
            Map parametros = new HashMap();
         //   bytes = JasperRunManager.runReportToPdf(relatorioJasper, null, jrRS);
             bytes = JasperRunManager.runReportToPdf(relatorioJasper, parametros, jrRS);
        } catch (Exception e) {
            System.out.println("Erro ao carregar o relatorio " + e.getMessage());
        }
        if (bytes != null && bytes.length > 0) {
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            response.getOutputStream().write(bytes, 0, bytes.length);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
