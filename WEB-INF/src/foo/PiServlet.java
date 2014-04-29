package foo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PiServlet extends HttpServlet {
	static int viewcount = 0;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

			PrintWriter out = resp.getWriter();
			// 
			out.println("ProjPiServlet");
			out.println( new java.util.Date());
			out.println( "viewcount = " + viewcount );
			viewcount++;

			/*
			   Montecarlo PI
			 */
			{
				double i,imax,n;
				double x,y,pi;

				n=0.0;
				imax=10000000.0;

				for(i=0;i<=imax;i++) 
				{
					x=Math.random();
					y=Math.random();        

					if((x*x+y*y)<1.0) 
					{
						n+=1.0;
					}
				}

				pi=n/imax*4.0;

				out.println("PI = " + pi);

			}

		}
}
