package com.satyam.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.JobSeeker;
import com.satyam.util.HibernateUtil;

public class CreateLobApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		byte[] imageContent = null;
		char[] resumeContent = null;
		JobSeeker seeker = null;
		boolean flag = false;

		try (FileInputStream fis = new FileInputStream("photo.png")) {
			imageContent = new byte[fis.available()];
			fis.read(imageContent);

			File f = new File("resume.txt");
			try (FileReader fr = new FileReader(f)) {
				resumeContent = new char[(int) f.length()];
				fr.read(resumeContent);
			}

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				seeker = new JobSeeker();
				seeker.setJsName("Binod");
				seeker.setPhoto(imageContent);
				seeker.setResume(resumeContent);
				seeker.setActive(true);

				session.save(seeker);
				flag = true;
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to DB....");
			} else {
				transaction.rollback();
				System.out.println("Object failed to save to DB....");
			}
		}

	}

}
