package com.brian;

public class EmailCreator {
    Email e = new Email();

    private String[] csv = {"   james   ,butler,jbutler@gmail.com",
            "Josephine,Darakjy,Josephine_Darakjy@darakjy.org",
            "ART,VENERE,ART@VENERE.ORG"};

    private String template = "To:      {email}\n" +
            "From:    noreply@deals.com\n" +
            "Subject: Deals!\n\n" +
            "Hi {first_name},\n\n" +
            "We've got some great deals for you. Check our website!";

    public void createEmail() {
        System.out.println("Email Creator\n");
        for (int i = 0; i < csv.length; i++) {
            String[] str = {csv[i]};
            str = str[0].split(",");
            e.setName(str[0]);
            e.setEmail(str[2]);
            String email = template.replace("{email}", e.getEmail());
            email = email.replace("{first_name}", e.getName());
            System.out.println("================================================================");
            System.out.println(email);

        }
    }
}