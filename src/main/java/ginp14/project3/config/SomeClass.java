package ginp14.project3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class SomeClass
{
    @Autowired
    private TemplateEngine templateEngine;

    public String generateMailHtml(String text, String templateFileName, Context context)
    {
        //Name of the template file without extension
        String output = this.templateEngine.process(templateFileName, context);
        return output;
    }
}
