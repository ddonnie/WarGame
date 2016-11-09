package com.dnd.common.controller;

import com.dnd.common.entity.Army;
import com.dnd.common.entity.ArmyForm;
import com.dnd.common.entity.Battleground;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public String summaryArmyForm(Model model) {
        model.addAttribute("armyForm", new ArmyForm());
        return "summary";
    }

    @RequestMapping(value = "/summary", method = RequestMethod.POST)
    public String summaryArmySubmit(@ModelAttribute ArmyForm armyForm, Model model) {
        model.addAttribute("armyForm", armyForm);
        Army leftArmy = new Army();
        leftArmy.setArmyName(armyForm.getArmyNameLeft());
        leftArmy.setArmySize(armyForm.getArmySizeLeft());
        leftArmy.fillArmy();
        Army rightArmy = new Army();
        rightArmy.setArmyName(armyForm.getArmyNameRight());
        rightArmy.setArmySize(armyForm.getArmySizeRight());
        rightArmy.fillArmy();
        Battleground battleground = new Battleground(leftArmy, rightArmy, 100);
        model.addAttribute("winner", battleground.battle());
        model.addAttribute("battleLog", battleground.getBattleLog());
        return "battle";
    }

    @RequestMapping (value = "/battle", method = RequestMethod.GET)
    public String battleResolve(@ModelAttribute("winner") Army army, @ModelAttribute("battleLog") String battleLog, Model model) {
        return "battle";
    }

}
