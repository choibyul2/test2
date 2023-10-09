package com.kosa.starrydonuts;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UTF8EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // �ʱ�ȭ ���� (�ʿ��ϴٸ�)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // ��û�� ���信 ���� UTF-8 ���ڵ� ����
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // ���� ���� �Ǵ� �������� ��û�� ���� ����
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // ���� �ı� ���� (�ʿ��ϴٸ�)
    }
}