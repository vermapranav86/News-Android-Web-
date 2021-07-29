/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import PKGJava.Api_Call;
import PKGJava.NewsData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sawan
 */
public class APIcall extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url="https://newsapi.org/v2/top-headlines?country=in&apiKey=9a8ba58a81e34daeaf3b18f343968a91";
           String type = request.getParameter("type");
           System.out.print(type+"    nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
            if(type==null)
                url="https://newsapi.org/v2/top-headlines?country=in&apiKey=9a8ba58a81e34daeaf3b18f343968a91";
            else if(type.equals("ent"))
            {
                url="https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=9a8ba58a81e34daeaf3b18f343968a91";
            }
            else if(type.equals("sport"))
            {
                url="http://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=9a8ba58a81e34daeaf3b18f343968a91";
            }
            else  if(type.equals("tech"))
            {
               
                url=" http://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=9a8ba58a81e34daeaf3b18f343968a91";
            }
             else
            {
                url=" http://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=9a8ba58a81e34daeaf3b18f343968a91";
            }
            
            
            ArrayList<NewsData> array =Api_Call.apicall(url);
            request.getSession().setAttribute("DataArray", array);
            response.sendRedirect("home.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,NullPointerException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,NullPointerException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
