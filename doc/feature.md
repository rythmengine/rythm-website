# Rythm Features
    
Rythm is yet another Java Template Engine. It provides an easy to use, super fast and general purpose template engine to Java programmer.

### General purpose

As a general purpose template engine, Rythm allows you to generate html page, xml file, source code, SQL script, email content and any other kind of text based artifacts.

### Static typed and Super fast

Unlike dynamic typed engines like [Velocity](http://velocity.apache.org/) and [FreeMarker](http://freemarker.sourceforge.net/), you need to declare template arguments in a Rythm template:

    @args User user
    Hi @user.getFullName(),

It looks not so convenient to declare template arguments, but it gives you a huge gain in performance. Based on [this](https://github.com/greenlaw110/template-engine-benchmarks) benchmark, Rythm is 2 to 3 times faster than velocity.

![benchmark-image](img/benchmark.png)

### .Net Razor like syntax

One of the motivation to create Rythm is I love [.Net Razor](http://weblogs.asp.net/scottgu/archive/2010/07/02/introducing-razor.aspx)'s clean syntax, and I want it in Java: 

![razor_like_syntax-image](img/razor_like_syntax.png)

Like Razor, Rythm also has only one special character: `@`. You use it for expression evaluation, method call, directive and all. As the comparison, Velocity uses `$` and `#` to in its [VTL](http://velocity.apache.org/engine/releases/velocity-1.7/vtl-reference-guide.html) syntax.

### Template auto reload

Rythm has 2 modes: **prod**(Product) and **dev**(Development). 

Under development mode, Rythm monitor template source files, and automatically reload the content once one changes. This process is very fast, usually you won't be able to notice the delay. 

Under product mode, auto reload feature is disabled to maximize the performance gain.

### Java programmer friendly

Rythm should not be strange to Java programmers as the syntax are basically come from Java:

    <ul>
    @for(User user: users) {
        <li class="@user_parity">
            <a href="/user/@user.getId()">@user.getFullName()</a>
        </li>
    }
    </ul>

    @if (user.isSuperUser()) {
        @superUserPanel() @// load superUserPanel template
    } else if (user.isManager()) {
        @managerPanel() @// load managerPanel template
    } else {
        @userPanel() @// load userPanel template
    }

Rythm API is very lightweight. You can use Rythm with zero configuration.

    // inline template
    String s = Rythm.render("Hello @who", "world");
    
    // external file template
    String s = Rythm.render("hello.txt", "world");
    
    // pass render arguments by position
    String s = Rythm.render("Hello @who", "world");
    
    // pass render arguments by name
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("who", "world");
    String s = Rythm.render("Hello @who", params);

### Extensibility and reusability

Rythm provides varieties of ways for template author to reuse and extend their template library, including:

* **External tags**: Most common and powerful way to extend template library. Each single template file is a rythm tag and can be called from any other templates, and even call back calling template from the tag template.
* **Internal tags**: Defining an internal tag is as simple as defining a method of a class
* **Macro**: The fastest way to reuse code block inside one template file
* **Include directive**: Including other template content in place at parsing time, and reuse internal tags defined in the including template.
    
### Rich functionality

Rythm provides wide range of templating features includes

* Template layout management
* External and internal tags
* Tag callback (external tag only)
* Java extension
* Template cache
* Recursive tag invocation

