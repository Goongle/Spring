package project.Myprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public static final String ePW = createKey();

    private MimeMessage createMessage(String to)throws Exception{
        System.out.println("보내는 대상 : "+ to);
        System.out.println("인증 번호 : "+ ePW);
        MimeMessage  message = javaMailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, to);//보내는 대상
        message.setSubject("인증번호가 도착했습니다.");//제목

        String msgg="";
        msgg+= "<div style='margin:100px;'>";
        msgg+= "<h1> 안녕하세요. 장수창. 입니다!!! </h1>";
        msgg+= "<br>";
        msgg+= "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요<p>";
        msgg+= "<br>";
        msgg+= "<p>감사합니다!<p>";
        msgg+= "<br>";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3 style='color:blue;'>회원가입 코드입니다.</h3>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "CODE : <strong>";
        msgg+= ePW +"</strong><div><br/> ";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("prime4floor@gmail.com","장수창"));//보내는 사람
        // InternetAddress 클래스에 주소와 이름을 넣어서 messeage 생성
        return message;
    }


    // MimeMessage 같은 경우 멀티미디어 메세지를 보낼 수 있다.
    // SimpleMailMessage 같은 경우 단순 텍스트 데이터만 보낼 수 있다.
    // 인증 코드 만들기
    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rnd.nextInt(3); // 0~2 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    //  a~z  (ex. 1+97=98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    //  A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }

        return key.toString();
    }


    public void sendSimpleMessage (String to) throws Exception {
        // 이메일 보내는 Method
        MimeMessage message = createMessage(to);
        try{
            System.out.println("asdasd");
            System.out.println(message.getFrom());
            System.out.println(message.getSender());
            javaMailSender.send(message);
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

}
