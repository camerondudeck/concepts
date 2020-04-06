package net.camerondudeck.songsofwar.utils;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ArmorstandBuilder allows you to create and spawn armorstands quick and easy
 */
public class ArmorstandBuilder {

	@Getter
	private ItemStack itemInMainHand = null;
	@Getter
	private ItemStack itemInOffHand = null;
	@Getter
	private ItemStack boots = null;
	@Getter
	private ItemStack leggings = null;
	@Getter
	private ItemStack chestplate = null;
	@Getter
	private ItemStack helmet = null;

	@Getter
	private float rotation = 0;
	
	@Getter
	private EulerAngle headPose = null;
	@Getter
	private EulerAngle bodyPose = null;
	@Getter
	private EulerAngle rightArmPose = null;
	@Getter
	private EulerAngle leftArmPose = null;
	@Getter
	private EulerAngle rightLegPose = null;
	@Getter
	private EulerAngle leftLegPose = null;

	@Getter
	private boolean basePlate = true;
	@Getter
	private boolean visible = true;
	@Getter
	private boolean arms = false;
	@Getter
	private boolean small = false;
	@Getter
	private boolean glowing = false;
	@Getter
	private boolean gravity = true;
	@Getter
	private boolean showName = false;
	@Getter
	private boolean silent = false;

	@Getter
	private Location location = null;
	@Getter
	private List<Entity> passengers = new ArrayList<>();
	@Getter
	private String name = "";

	public ArmorstandBuilder(Location location) {
		this.location = location;
	}

	/**
	 * Set the armorstand name
	 *
	 * @param name name of the armorstand
	 * @return this
	 */
	public ArmorstandBuilder name(String name) {
		this.name = name;

		return this;
	}

	/**
	 * Set the passengers of the armorstand
	 *
	 * @param passengers list of passengers
	 * @return this
	 */
	public ArmorstandBuilder passengers(List<Entity> passengers) {
		this.passengers = passengers;

		return this;
	}

	/**
	 * Set the boolean of the basePlate
	 *
	 * @param basePlate value of the boolean
	 * @return this
	 */
	public ArmorstandBuilder basePlate(boolean basePlate) {
		this.basePlate = basePlate;

		return this;
	}

	/**
	 * Set the boolean of the visible
	 *
	 * @param visible value of the boolean
	 * @return this
	 */
	public ArmorstandBuilder visible(boolean visible) {
		this.visible = visible;

		return this;
	}

	/**
	 * Set the boolean of the arms
	 *
	 * @param arms value of the boolean
	 * @return this
	 */
	public ArmorstandBuilder arms(boolean arms) {
		this.arms = arms;

		return this;
	}

	/**
	 * Set the boolean of the small
	 *
	 * @param small value of the boolean
	 * @return this
	 */
	public ArmorstandBuilder small(boolean small) {
		this.small = small;

		return this;
	}

	/**
	 * Set the boolean of the glowing
	 *
	 * @param glowing value of the boolean
	 * @return this
	 */
	public ArmorstandBuilder glowing(boolean glowing) {
		this.glowing = glowing;

		return this;
	}

	/**
	 * Set the boolean of the gravity
	 *
	 * @param gravity value of the boolean
	 * @return this
	 */
	public ArmorstandBuilder gravity(boolean gravity) {
		this.gravity = gravity;

		return this;
	}

	/**
	 * Set the boolean of the showName
	 *
	 * @param showName value of the boolean
	 * @return this
	 */
	public ArmorstandBuilder showName(boolean showName) {
		this.showName = showName;

		return this;
	}

	/**
	 * Set the boolean of the silent
	 *
	 * @param silent value of the boolean
	 * @return this
	 */
	public ArmorstandBuilder silent(boolean silent) {
		this.silent = silent;

		return this;
	}

	/**
	 * Set the position of the head
	 *
	 * @param headPose value of the angle
	 * @return this
	 */
	public ArmorstandBuilder headPose(EulerAngle headPose) {
		this.headPose = headPose;

		return this;
	}

	/**
	 * Set the position of the body
	 *
	 * @param bodyPose value of the angle
	 * @return this
	 */
	public ArmorstandBuilder bodyPose(EulerAngle bodyPose) {
		this.bodyPose = bodyPose;

		return this;
	}

	/**
	 * Set the position of the right arm
	 *
	 * @param rightArmPose value of the angle
	 * @return this
	 */
	public ArmorstandBuilder rightArmPose(EulerAngle rightArmPose) {
		this.rightArmPose = rightArmPose;

		return this;
	}

	/**
	 * Set the position of the left arm
	 *
	 * @param leftArmPose value of the angle
	 * @return this
	 */
	public ArmorstandBuilder leftArmPose(EulerAngle leftArmPose) {
		this.leftArmPose = leftArmPose;

		return this;
	}

	/**
	 * Set the position of the right leg
	 *
	 * @param rightLegPose value of the angle
	 * @return this
	 */
	public ArmorstandBuilder rightLegPose(EulerAngle rightLegPose) {
		this.rightLegPose = rightLegPose;

		return this;
	}

	/**
	 * Set the position of the left leg
	 *
	 * @param leftLegPose value of the angle
	 * @return this
	 */
	public ArmorstandBuilder leftLegPose(EulerAngle leftLegPose) {
		this.leftLegPose = leftLegPose;

		return this;
	}

	/**
	 * Set the item in the main hand
	 *
	 * @param itemInMainHand item to be set
	 * @return this
	 */
	public ArmorstandBuilder itemInMainHand(ItemStack itemInMainHand) {
		this.itemInMainHand = itemInMainHand;

		return this;
	}

	/**
	 * Set the item in the off hand
	 *
	 * @param itemInOffHand item to be set
	 * @return this
	 */
	public ArmorstandBuilder itemInOffHand(ItemStack itemInOffHand) {
		this.itemInOffHand = itemInOffHand;

		return this;
	}

	/**
	 * Set the item on boots
	 *
	 * @param boots item to be set
	 * @return this
	 */
	public ArmorstandBuilder boots(ItemStack boots) {
		this.boots = boots;

		return this;
	}

	/**
	 * Set the item on leggings
	 *
	 * @param leggings item to be set
	 * @return this
	 */
	public ArmorstandBuilder leggings(ItemStack leggings) {
		this.leggings = leggings;

		return this;
	}

	/**
	 * Set the item on chestplate
	 *
	 * @param chestplate item to be set
	 * @return this
	 */
	public ArmorstandBuilder chestplate(ItemStack chestplate) {
		this.chestplate = chestplate;

		return this;
	}

	/**
	 * Set the item on helmet
	 *
	 * @param helmet item to be set
	 * @return this
	 */
	public ArmorstandBuilder helmet(ItemStack helmet) {
		this.helmet = helmet;

		return this;
	}

	/**
	 * Set the rotation
	 *
	 * @param yaw
	 * @return this
	 */

	public ArmorstandBuilder rotation(float yaw){
		this.rotation = yaw;

		return this;
	}

	/**
	 * SpawnCommand the armorstand with all the values
	 *
	 * @return armorstand entity
	 */
	public ArmorStand spawnEntity() {
		ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

		armorStand.setBasePlate(basePlate);
		armorStand.setVisible(visible);
		armorStand.setArms(arms);
		armorStand.setSmall(small);
		armorStand.setGlowing(glowing);
		armorStand.setGravity(gravity);
		armorStand.setCustomNameVisible(showName);
		armorStand.setSilent(silent);
		armorStand.setCustomName(name);
		armorStand.setInvulnerable(true);
		armorStand.setCanPickupItems(false);

		//armorStand.setRotation(rotation, null);

		if(helmet != null) armorStand.getEquipment().setHelmet(helmet);
		if(chestplate != null) armorStand.getEquipment().setChestplate(chestplate);
		if(leggings != null) armorStand.getEquipment().setLeggings(leggings);
		if(boots != null) armorStand.getEquipment().setBoots(boots);
		if(itemInMainHand != null) armorStand.getEquipment().setItemInMainHand(itemInMainHand);
		if(itemInOffHand != null) armorStand.getEquipment().setItemInOffHand(itemInOffHand);

		if(headPose != null) armorStand.setHeadPose(headPose);
		if(bodyPose != null) armorStand.setBodyPose(bodyPose);
		if(leftArmPose != null) armorStand.setLeftArmPose(leftArmPose);
		if(rightArmPose != null) armorStand.setRightArmPose(rightArmPose);
		if(leftLegPose != null) armorStand.setLeftLegPose(leftLegPose);
		if(rightLegPose != null) armorStand.setRightLegPose(rightLegPose);

		for(Entity passenger : passengers) {
			armorStand.addPassenger(passenger);
		}

		return armorStand;
	}
}