package com.myntra.utility;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BrowserDetails {
    private String title;
    private String url;
    private String windowHandle;
    private Dimension windowSize;
    private List<String> cookies;

    public BrowserDetails(String title, String url, String windowHandle, Dimension windowSize, Set<Cookie> cookies) {
        this.title = title;
        this.url = url;
        this.windowHandle = windowHandle;
        this.windowSize = windowSize;
        this.cookies = cookies.stream()
                              .map(cookie -> cookie.getName() + "=" + cookie.getValue())
                              .collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getWindowHandle() {
        return windowHandle;
    }

    public Dimension getWindowSize() {
        return windowSize;
    }

    public List<String> getCookies() {
        return cookies;
    }

    @Override
    public String toString() {
        return "Current Webpage Details:\n" +
               "--------------------------------------------------\n" +
               "Title: " + title + "\n" +
               "URL: " + url + "\n" +
               "Window Handle: " + windowHandle + "\n" +
               "Window Dimensions: " + windowSize + "\n" +
               "Cookies List: \n" + (cookies.isEmpty() ? "No Cookies Found" : String.join("\n", cookies)) + "\n" +
               "--------------------------------------------------";
    }
}
