package querydsl.firstclasscollection.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
public class Tags {

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Tag> tags = new ArrayList<>();

    public void addAll(List<Tag> tags) {
        this.tags.addAll(tags);
    }

    public String getJoinedTitles() {
        List<String> titles = tags.stream()
                .map(Tag::getTitle)
                .collect(Collectors.toList());
        return String.join(",", titles);
    }
}
