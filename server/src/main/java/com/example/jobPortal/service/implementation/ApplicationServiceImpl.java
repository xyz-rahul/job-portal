package com.example.jobPortal.service.implementation;

import com.example.jobPortal.entity.Application;
import com.example.jobPortal.entity.Company;
import com.example.jobPortal.entity.Job;
import com.example.jobPortal.entity.User;
import com.example.jobPortal.payload.application.ApplicationDto;
import com.example.jobPortal.payload.company.CompanyDto;
import com.example.jobPortal.repository.ApplicationRepository;
import com.example.jobPortal.repository.JobRepository;
import com.example.jobPortal.repository.UserRepository;
import com.example.jobPortal.service.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ApplicationDto applyForJob(Integer userId, Integer jobId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Job> jobOptional = jobRepository.findById(jobId);

        if (userOptional.isPresent() && jobOptional.isPresent()) {
            User user = userOptional.get();
            Job job = jobOptional.get();

            Application application = new Application();
            application.setUser(user);
            application.setJob(job);

            Application savedApplication = applicationRepository.save(application);
            return modelMapper.map(savedApplication, ApplicationDto.class);
        }
        return null;
    }

    public ApplicationDto getApplicationById(int id){
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        return applicationOptional.map(application -> modelMapper.map(application, ApplicationDto.class)).orElse(null);
    }

    @Override
    public List<ApplicationDto> getApplicationsByUser(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Application> applications = applicationRepository.findByUser(user);
            return applications.stream()
                    .map(application -> modelMapper.map(application, ApplicationDto.class))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<ApplicationDto> getApplicationsByJob(Integer jobId) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            List<Application> applications = applicationRepository.findByJob(job);
            return applications.stream()
                    .map(application -> modelMapper.map(application, ApplicationDto.class))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public boolean withdrawApplication(Integer id) {
        if (applicationRepository.existsById(id)) {
            applicationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //todo
    @Override
    public boolean rejectApplication(Integer id) {
        return false;
    }
}
