package java76.pms.util;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SearchSchool2 {

  public String search() {
    String html = "";
    String count = "0";
    try{
      String queryURL = "www.career.go.kr/cnet/openapi/getOpenApi?apiKey=701eb0e5533f950953a9e92ec4b65744&svcType=api&svcCode=SCHOOL&contentType=xml&gubun=elem_list";

      URL url = new URL(queryURL);
      URLConnection connection = url.openConnection();
      InputStream is = connection.getInputStream();

      // 3. 질의결과 받기
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(is);

      // 4. 파싱
      Element root = doc.getDocumentElement();

      if("jobSearch".equals(root.getNodeName())){
        NodeList nodelist =  root.getChildNodes();

        for(int i=0; i<nodelist.getLength(); i++){
          // root node중 item node만  처리
          Node item = nodelist.item(i);

          if("list".equals(item.getNodeName())) {
            // list만 처리
            NodeList itemList = item.getChildNodes();

            count = item.getAttributes().getNamedItem("totalCount").getNodeValue();

            html = "<table class=\"table_t5\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"540\" height=\"34\">"+
                "<tr>"+
                "<td width=\"44\">"+
                "<p align=\"center\"><font color=\"white\">학교명</font></p>"+
                "</td>"+
                "<td width=\"135\">"+
                "<p align=\"center\"><font color=\"white\">학교종류</font></p>"+
                "</td>"+
                "<td width=\"120\">"+
                "<p align=\"center\"><font color=\"white\">학교유형</font></p>"+
                "</td>"+
                "<td width=\"241\">"+
                "<p align=\"center\"><font color=\"white\">지역</font></p>"+
                "</td>"+
                "</tr>"+
                "</table>";

            html += "<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"540\" height=\"34\">";
            for(int j=0; j<itemList.getLength(); j++){

              Node items = itemList.item(j);

              if("content".equals(items.getNodeName())){
                // content만 처리
                NodeList itemList2 = items.getChildNodes();

                Node rnum = itemList2.item(1);
                Node schoolName = itemList2.item(3);
                Node schoolGubun = itemList2.item(5);
                Node schoolType = itemList2.item(7);
                Node region = itemList2.item(9);

                html += "<tr>" +
                    "<td width=\"44\" class=\"board_td_sky\">"+
                    "<p align=\"center\">"+rnum.getTextContent()+"</p>"+
                    "</td>"+
                    "<td width=\"135\" class=\"board_td_sky\">"+
                    "<p align=\"left\"><a onclick=\"javascript:getDetail("+schoolName.getTextContent()+",'','');\" title=\"상세보기\" style=\"cursor:pointer\">"+schoolGubun.getTextContent()+"</a></p>"+
                    "</td>"+
                    "<td width=\"120\" class=\"board_td_sky\">"+
                    "<p align=\"left\">"+schoolType.getTextContent()+"</p>"+
                    "</td>"+
                    "<td width=\"241\" class=\"board_td_sky\">"+
                    "<p align=\"left\">"+region.getTextContent()+"</p>"+
                    "</td>"+
                    "</tr>";

              }
            }

            if(itemList.getLength()==0){
              html += "<tr>"+
                  "<td width=\"540\" height=\"150\">"+
                  "<p><font color=\"#FF320A\"><strong>검색결과</strong></font>가  없습니다.</p>"+
                  "</td>"+
                  "</tr>";

            }
            html += "</table>";
          }
        }
      }

    }catch(Exception e){
      e.printStackTrace();
    }

    return html;
    
  }


}
