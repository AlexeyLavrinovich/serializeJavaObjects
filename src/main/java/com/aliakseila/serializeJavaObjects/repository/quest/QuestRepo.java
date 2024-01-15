package com.aliakseila.serializeJavaObjects.repository.quest;

import com.aliakseila.serializeJavaObjects.entity.quest.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepo <T extends Quest> extends JpaRepository<T, Long> {
}
