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

       // get the instructor detail object
      val searchId = 2
      val tempInstructorDetail = session.get(InstructorDetail::class.java, searchId)

      // print the instructor detail
      println("tempInstructorDetail: $tempInstructorDetail")

      // print the associated instructor
      println("the associated instructor: ${tempInstructorDetail.instructor}")
      println("Done!")
      session.transaction.commit()
   }

}