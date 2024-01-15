package com.aliakseila.serializeJavaObjects;

import com.aliakseila.serializeJavaObjects.entity.User;
import com.aliakseila.serializeJavaObjects.entity.quest.GatherQuest;
import com.aliakseila.serializeJavaObjects.entity.quest.Quest;
import com.aliakseila.serializeJavaObjects.repository.ItemRepo;
import com.aliakseila.serializeJavaObjects.repository.UserRepo;
import com.aliakseila.serializeJavaObjects.repository.quest.GatherQuestRepo;
import com.aliakseila.serializeJavaObjects.repository.quest.KillQuestRepo;
import com.aliakseila.serializeJavaObjects.repository.quest.QuestRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import java.util.List;

@DataJpaTest
class SerializeJavaObjectsApplicationTests {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	private QuestRepo questRepo;
	@Autowired
	private KillQuestRepo killQuestRepo;
	@Autowired
	private GatherQuestRepo gatherQuestRepo;

	@Test
	public void JackSparrowEarnMoney() {
		addExecutor();
		User Jack_Sparrow = userRepo.findByUsername("Captain Jack Sparrow");
		Jack_Sparrow.getQuests().forEach(Quest::passTheQuest);
		userRepo.save(Jack_Sparrow);

		Assert.isTrue(Jack_Sparrow.getMoney() > 100.0, "sad");
	}

	private void addExecutor(){
		User Jack_Sparrow = userRepo.findByUsername("Captain Jack Sparrow");
		List<GatherQuest> gatherQuests = gatherQuestRepo.findAll();
		gatherQuests.stream()
				.filter(q -> !q.getCreator().getUsername().equals(Jack_Sparrow.getUsername()))
				.toList()
				.forEach(q -> {
					q.setExecutor(Jack_Sparrow);
					List<Quest> quests = Jack_Sparrow.getQuests();
					quests.add(q);
					Jack_Sparrow.setQuests(quests);
				});
		gatherQuestRepo.saveAll(gatherQuests);
	}
}
