package com.example.demo.factory;

public class RubricBean {
    String id;
    String name;
    String type;
    String source;
    String tool;
    String content;
    String motifyId;

    public RubricBean() {
    }

    public RubricBean(String id, String name, String type, String source, String tool, String content, String motifyId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.source = source;
        this.tool = tool;
        this.content = content;
        this.motifyId = motifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMotifyId() {
        return motifyId;
    }

    public void setMotifyId(String motifyId) {
        this.motifyId = motifyId;
    }
}
