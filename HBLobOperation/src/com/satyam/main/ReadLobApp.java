package com.satyam.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.satyam.Model.JobSeeker;
import com.satyam.util.HibernateUtil;

public class ReadLobApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		JobSeeker seeker = null;
		boolean flag = false;

		try {
			if (session != null)
				seeker = session.get(JobSeeker.class, 1);

			if (seeker != null) {
				try (FileOutputStream fos = new FileOutputStream("store/photo.png")) {
					fos.write(seeker.getPhoto());
				}

				try (FileWriter fos = new FileWriter("store/resume.txt")) {
					fos.write(seeker.getResume());
				}

				flag = true;
			} else {
				System.out.println("Object not available in db :: ");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		} finally {

			if (flag) {
				System.out.println("Object saved to DB....");
			} else {
				System.out.println("Object failed to save to DB....");
			}
		}

	}

}
