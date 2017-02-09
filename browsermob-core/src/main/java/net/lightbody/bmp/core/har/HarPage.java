package net.lightbody.bmp.core.har;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HarPage {
    private volatile String id;
    private volatile Date startedDateTime;
    private volatile String title = "";
    private final HarPageTimings pageTimings = new HarPageTimings();
    private volatile String comment = "";

    private volatile ConcurrentHashMap<String, String> tags = new ConcurrentHashMap();
    private volatile ConcurrentHashMap<String, Integer> metrics = new ConcurrentHashMap();

    public HarPage() {
    }

    public HarPage(String id) {
        this(id, "");
    }

    public HarPage(String id, String title) {
        this.id = id;
        this.title = title;
        startedDateTime = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    public Date getStartedDateTime() {
        return startedDateTime;
    }

    public void setStartedDateTime(Date startedDateTime) {
        this.startedDateTime = startedDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HarPageTimings getPageTimings() {
        return pageTimings;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // custom field per HAR spec we will use for arbitrary tagging data
    public ConcurrentHashMap<String, String> get_tags(){ return this.tags; }

    public void addTag(String tagName, String tagValue) throws Exception{
        this.tags.put(tagName, tagValue);
    }


    // custom field per HAR spec we will use for arbitrary metric data
    public ConcurrentHashMap<String, Integer> get_metrics(){ return this.metrics; }

    public void addMetric(String metricName, Integer metricValue) throws Exception{
        this.metrics.put(metricName, metricValue);
    }


}
