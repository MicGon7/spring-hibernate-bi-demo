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
      session.beginTransaction()

       // get instructor by primary key
      val searchId = 1
      val instructor = session.get(Instructor::class.java, searchId)

      println("Found instructor $instructor")

      // delete instructor
      instructor?.let {
         println("deleting $instructor")
         // this will also delete the detail object since cascade type is sent to all
         session.delete(instructor)
      }

      println("Done!")
      session.transaction.commit()
   }

}