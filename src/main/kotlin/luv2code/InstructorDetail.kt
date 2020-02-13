package luv2code

import javax.persistence.*

@Entity
@Table(name = "instructor_detail")
class InstructorDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id: Int = 0,

    @Column(name = "youtube_channel")
    private val youtubeChannel: String,

    @Column(name = "hobby")
    private val hobby: String,

    // add new field for instructor
    @OneToOne(mappedBy = "instructorDetail", cascade = [CascadeType.ALL])
    var instructor: Instructor? = null

) {
    override fun toString(): String {
        return "InstructorDetail(id=$id, youtubeChannel='$youtubeChannel', hobby='$hobby')"
    }
}
