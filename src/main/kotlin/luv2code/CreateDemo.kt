package luv2code

import org.hibernate.cfg.Configuration

fun main(args: Array<String>) {

   // create session factory
   val factory = Configuration()
      .configure() // this will automatically load hibernate.cfg.xml file
      .addAnnotatedClass(Instructor::class.java)
      .addAnnotatedClass(InstructorDetail::class.java)
      .buildSessionFactory()

   // create session
   val session = factory.currentSession

   factory?.use {
      // now use the session object to save/retrieve java object
      println("Creating new object...")
      val tempInstructor = Instructor (firstName = "Madhu", lastName = "Patel", email = "Madhu@gmail.com")
      val instructorDetail = InstructorDetail(youtubeChannel = "www.music.com", hobby =  "Guitar")
      // associate the objects
      tempInstructor.instructorDetail = instructorDetail

      // this will also save the details object because of CascadeType.ALL

      session.beginTransaction()

      println("saving $tempInstructor")
      session.save(tempInstructor)

      println("Done!")
      session.transaction.commit()
   }

}