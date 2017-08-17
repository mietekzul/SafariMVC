package pl.raziel.mvc.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class GlobalInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HitCounter counter;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        counter.setHits(counter.getHits() + 1);
        System.out.println("Hits: " + counter.getHits());
        request.setAttribute("currentDate", new Date());
        return super.preHandle(request, response, handler);
    }
}
