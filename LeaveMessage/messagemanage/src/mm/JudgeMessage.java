/*
查看留言板
*/
package mm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class JudgeMessage extends HttpServlet {
    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
     * HttpServletRequest , javax.servlet.http.HttpServletResponse)
     */
    //主要用于查看留言板留言属性
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql_judge;

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");


        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        sql_judge="SELECT user_id,messageId,name,DATE_FORMAT(time,'%Y-%m-%d %H:%i:%s') as time,message,messageType,background,fontColor FROM messages where messageType='"+0+"'";

        try {
            SQLdemo te = new SQLdemo();

            System.out.println("Write Operation succeed");

            PrintWriter out = resp.getWriter();
            out.print(te.ShowMessage(sql_judge));                                   //返回 待审核留言信息 给前端

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

}

