package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    //отрабатывает тогда, когда мы включаем наш томкат, если не надо, чтобы отрабатывало-ничего не пишем
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //над фильтром -от браузера к сервлету
        //канал фильтров filterChain
        filterChain.doFilter(req,resp);
        //под фильтром -от сервлета к браузеру
    }

    @Override
    //отрабатывает в момент выключения томката
    public void destroy() {

    }
}
