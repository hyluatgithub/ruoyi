package com.ruoyi.content.handle;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 *
 * shouldVisit: 这个方法主要是决定哪些url我们需要抓取，返回true表示是我们需要的，返回false表示不是我们需要的Url第一个参数referringPage封装了当前爬取的页面信息 第二个参数url封装了当前爬取的页面url信息
 * visit: 该功能在URL内容下载成功后调用。
 * 您可以轻松获取下载页面的网址，文本，链接，html和唯一ID
 *
 */
public class MyCrawler extends WebCrawler {
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");
    /**
     * This method receives two parameters. The first parameter is the page
     * in which we have discovered this new url and the second parameter is
     * the new url. You should implement this function to specify whether
     * the given url should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the crawler to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "https://www.ics.uci.edu/". In this case, we didn't need the
     * referringPage parameter to make the decision.
     *
     * 这个方法主要是决定哪些url我们需要抓取，返回true表示是我们需要的，返回false表示不是我们需要的Url
     * 第一个参数referringPage封装了当前爬取的页面信息 第二个参数url封装了当前爬取的页面url信息
     * 在这个例子中，我们指定爬虫忽略具有css，js，git，...扩展名的url，只接受以“http://www.ics.uci.edu/”开头的url。
     * 在这种情况下，我们不需要referringPage参数来做出决定。
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();   // 得到小写的url
        return !FILTERS.matcher(href).matches();    // 正则匹配，过滤掉我们不需要的后缀文件
//                && href.startsWith("https://www.ics.uci.edu/");   // 只接受以“http://www.ics.uci.edu/”开头的url
    }

    /**
     * This function is called when a page is fetched and ready
     * to be processed by your program.
     *
     * 当一个页面被提取并准备好被你的程序处理时，这个函数被调用
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL(); // 获取url
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) { // 判断是否是html数据
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();  // 强制类型转换，获取html数据对象
            String text = htmlParseData.getText();  //获取页面纯文本（无html标签）
            String html = htmlParseData.getHtml();  //获取页面Html
            Set<WebURL> links = htmlParseData.getOutgoingUrls();    // 获取页面输出链接

            System.out.println("Text length: " + text.length());
            System.out.println("Html length: " + html.length());
            System.out.println("Number of outgoing links: " + links.size());
        }
    }
}
