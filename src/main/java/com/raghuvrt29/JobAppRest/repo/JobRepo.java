package com.raghuvrt29.JobAppRest.repo;

import com.raghuvrt29.JobAppRest.model.JobPost;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface JobRepo extends JpaRepository< JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

}
//public void addJob(JobPost jobPost){
//    jobs.add(jobPost);
//}
//
//public List<JobPost> getAllJobs(){
//    return jobs;
//}
//
//public JobPost getJob(int i) {
//    for(JobPost job : jobs){
//        if(job.getPostId() == i){
//            return job;
//        }
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for(JobPost job : jobs){
//        if(job.getPostId() == jobPost.getPostId()){
//            job.setPostDesc(jobPost.getPostDesc());
//            job.setPostProfile(jobPost.getPostProfile());
//            job.setReqExperience(jobPost.getReqExperience());
//            job.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob(int postID){
//    jobs.removeIf(job -> job.getPostId() == postID);
//}