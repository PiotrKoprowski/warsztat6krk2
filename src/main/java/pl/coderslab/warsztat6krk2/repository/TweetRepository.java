package pl.coderslab.warsztat6krk2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.warsztat6krk2.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
