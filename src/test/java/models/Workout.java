package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Workout {
    String date;
    String time;
    String name;
    String description;
    String distance;
    String duration;
    String perceivedEffort;
}
