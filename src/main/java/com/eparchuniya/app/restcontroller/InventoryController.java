package com.eparchuniya.app.restcontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eparchuniya.app.common.util.ItemPricing;
import com.eparchuniya.app.domain.inventory.Category;
import com.eparchuniya.app.domain.inventory.Item;
import com.eparchuniya.app.domain.inventory.ItemPrice;
import com.eparchuniya.app.domain.inventory.ItemPricePK;
import com.eparchuniya.app.domain.inventory.ItemType;
import com.eparchuniya.app.domain.inventory.ItemUnit;
import com.eparchuniya.app.domain.inventory.Packaging;
import com.eparchuniya.app.exception.ApiError;
import com.eparchuniya.app.exception.CustomUniqueKeyViolationException;
import com.eparchuniya.app.exception.NotExistException;
import com.eparchuniya.app.exception.ResponseCode;
import com.eparchuniya.app.exception.SuccessResponse;
import com.eparchuniya.app.security.service.LoggedInUserService;
import com.eparchuniya.app.service.InventoryService;

@RestController
@RequestMapping(value = "/inventorymanagement")
public class InventoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private LoggedInUserService loggedInUserService;
	
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public ResponseEntity<?> addCategory(@Valid @RequestBody Category category) {
		try{
			logger.info("adding new category : "+ category.getDisplayName());
			category.setCreatedBy(loggedInUserService.getUser());
			category.setCreatedTs(new Date());
			inventoryService.addCategory(category);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while saving new category : " + category.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("New category added successfully : "+ category.getDisplayName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Category added successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/category/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateCategory(@Valid @RequestBody Category category) {
		try{
			if(category.getCategoryId() <= 0)
			{
				logger.error("Exception while updaing category : " + category.getDisplayName() + " --> categoryId is given in payload");
				ApiError apiError = new ApiError(ResponseCode.BAD_REQUEST, "categoryId is given in payload");
				return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
			}
			logger.info("updating category : "+ category.getDisplayName());
			category.setModifiedBy(loggedInUserService.getUser());
			category.setModifiedTs(new Date());
			inventoryService.updateCategory(category);
		} catch(NotExistException ex) {
			logger.error("Exception while updaing category : " + category.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while updating category : " + category.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("category updated successfully : "+ category.getDisplayName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Category updated successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/itemtype/add", method = RequestMethod.POST)
	public ResponseEntity<?> addItemType(@Valid @RequestBody ItemType itemType) {
		try{
			logger.info("adding new itemType : "+ itemType.getDisplayName());
			itemType.setCreatedBy(loggedInUserService.getUser());
			itemType.setCreatedTs(new Date());
			inventoryService.addItemType(itemType);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while saving new itemType : " + itemType.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("New itemType added successfully : "+ itemType.getDisplayName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "ItemType added successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/itemtype/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateItemType(@Valid @RequestBody ItemType itemType) {
		try{
			if(itemType.getTypeId() <= 0)
			{
				logger.error("Exception while updaing itemType : " + itemType.getCode() + " --> typeId is not given in payload");
				ApiError apiError = new ApiError(ResponseCode.BAD_REQUEST, "typeId is not given in payload");
				return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
			}
			logger.info("updaing itemType : "+ itemType.getDisplayName());
			itemType.setModifiedBy(loggedInUserService.getUser());
			itemType.setModifiedTs(new Date());
			inventoryService.updateItemType(itemType);
		} catch(NotExistException ex) {
			logger.error("Exception while updaing itemType : " + itemType.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while updaing itemType : " + itemType.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("ItemType updated successfully : "+ itemType.getDisplayName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "ItemType updated successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/itemunit/add", method = RequestMethod.POST)
	public ResponseEntity<?> addItemUnit(@Valid @RequestBody ItemUnit itemUnit) {
		try{
			logger.info("adding new itemUnit : "+ itemUnit.getDisplayName());
			itemUnit.setCreatedBy(loggedInUserService.getUser());
			itemUnit.setCreatedTs(new Date());
			inventoryService.addItemUnit(itemUnit);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while saving new itemUnit : " + itemUnit.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("New itemUnit added successfully : "+ itemUnit.getDisplayName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Unit added successfully"), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/itemunit/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateItemUnit(@Valid @RequestBody ItemUnit itemUnit) {
		try{
			if(itemUnit.getUnitId() <= 0)
			{
				logger.error("Exception while updaing Item Unit : " + itemUnit.getCode() + " --> Unit is not given in payload");
				ApiError apiError = new ApiError(ResponseCode.BAD_REQUEST, "UnitId is not given in payload");
				return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
			}
			logger.info("updating itemUnit : "+ itemUnit.getDisplayName());
			itemUnit.setModifiedBy(loggedInUserService.getUser());
			itemUnit.setModifiedTs(new Date());
			inventoryService.updateItemUnit(itemUnit);
		} catch(NotExistException ex) {
			logger.error("Exception while updating itemUnit : " + itemUnit.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while updating itemUnit : " + itemUnit.getDisplayName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("itemUnit updated successfully : "+ itemUnit.getDisplayName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Unit updated successfully"), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/packaging/add", method = RequestMethod.POST)
	public ResponseEntity<?> addPackaging(@Valid @RequestBody Packaging packaging) {
		try{
			logger.info("adding new packaging : "+ packaging.getName());
			packaging.setCreatedBy(loggedInUserService.getUser());
			packaging.setCreatedTs(new Date());
			inventoryService.addPackaging(packaging);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while saving new packaging : " + packaging.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("New packaging added successfully : "+ packaging.getName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Packaging added successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/packaging/update", method = RequestMethod.POST)
	public ResponseEntity<?> updatePackaging(@Valid @RequestBody Packaging packaging) {
		try{
			logger.info("updating packaging : "+ packaging.getName());
			packaging.setModifiedBy(loggedInUserService.getUser());
			packaging.setModifiedTs(new Date());
			inventoryService.updatePackaging(packaging);
		} catch(NotExistException ex) {
			logger.error("Exception while updating packaging : " + packaging.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while updating packaging : " + packaging.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("packaging updated successfully : "+ packaging.getName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Packaging updated successfully"), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/packaging/enable/{packagingId}", method = RequestMethod.POST)
	public ResponseEntity<?> enablePackaging(@PathVariable int packagingId) {
		try{
			logger.info("request to enable packaging : "+ packagingId);
			inventoryService.enablePackaging(packagingId, loggedInUserService.getUser().getUserId());
		} catch(NotExistException ex) {
			logger.error("Exception while enabling packaging : " + packagingId + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("packaging enabling successfully : "+ packagingId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Packaging updated successfully"), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/packaging/desable/{packagingId}", method = RequestMethod.POST)
	public ResponseEntity<?> desablePackaging(@PathVariable int packagingId) {
		try{
			logger.info("request to desable packaging : "+ packagingId);
			inventoryService.enablePackaging(packagingId, loggedInUserService.getUser().getUserId());
		} catch(NotExistException ex) {
			logger.error("Exception while desabling packaging : " + packagingId + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		}
		logger.info("packaging desabled successfully : "+ packagingId);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Packaging desabled successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/item/add", method = RequestMethod.POST)
	public ResponseEntity<?> addItem(@Valid @RequestBody Item item) {
		try{
			logger.info("adding new item : "+ item.getName());
			item.setCreatedBy(loggedInUserService.getUser());
			item.setCreatedTs(new Date());
			ItemType itemType = item.getItemType();
			int codeNumber = 0;
			String code = null;
			while (true) {
				codeNumber = inventoryService.ItemCountByTypeId(itemType) + 1;
				code = itemType.getCode() + "-" + codeNumber;
				if(inventoryService.ItemFindByCode(code) == null)
					break;
			}
			item.setCode(code);
			inventoryService.addItem(item);
			if(item.getPackagings() != null){
				List<Packaging> packagings = item.getPackagings();
				for (Packaging packaging : packagings) {
					ItemPricePK itemPricePK = new ItemPricePK();
					itemPricePK.setPackaging(packaging);
					itemPricePK.setItem(item);
					ItemPrice itemPrice = new ItemPrice();
					itemPrice.setItemPricePK(itemPricePK);
					itemPrice.setCreatedBy(loggedInUserService.getUser());
					itemPrice.setCreatedTs(new Date());
					//get Item Price based on packaging
					logger.info("Fetching Item price based on packaging--> Item : " + item.getName() + "-->Packaging:"+packaging.getName());
					Double price = ItemPricing.getItemPriceBasedOnPackaging(item.getItemId(), packaging.getPackagingId());
					itemPrice.setPrice(price);
					inventoryService.addItemPrice(itemPrice);
				}
			}
			
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while saving new item : " + item.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("New item added successfully : "+ item.getName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Item added successfully"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/item/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateItem(@Valid @RequestBody Item item) {
		try{
			logger.info("updating item : "+ item.getName());
			item.setModifiedBy(loggedInUserService.getUser());
			item.setModifiedTs(new Date());
			inventoryService.updateItem(item);
			if(item.getPackagings() != null){
				List<Packaging> packagings = item.getPackagings();
				if(!packagings.isEmpty())
				{
					List<Integer> packagingIds = new ArrayList<Integer>();
					for(Packaging packaging : packagings) {
						packagingIds.add(packaging.getPackagingId());
					}
					// remove all packagings of item, those are not in selected packagings
					logger.info("removing all packagings of item, those are not in selected packagings");
					inventoryService.removeItemPriceNotInList(item.getItemId(), packagingIds);
					
					for (Packaging packaging : packagings) {
						if(inventoryService.ItemPriceFindById(item.getItemId(), packaging.getPackagingId()) == null)
						{
							ItemPricePK itemPricePK = new ItemPricePK();
							itemPricePK.setPackaging(packaging);
							itemPricePK.setItem(item);
							ItemPrice itemPrice = new ItemPrice();
							itemPrice.setItemPricePK(itemPricePK);
							itemPrice.setCreatedBy(loggedInUserService.getUser());
							itemPrice.setCreatedTs(new Date());
							//get Item Price based on packaging
							logger.info("Fetching Item price based on packaging--> Item : " + item.getName() + "-->Packaging:"+packaging.getName());
							Double price = ItemPricing.getItemPriceBasedOnPackaging(item.getItemId(), packaging.getPackagingId());
							itemPrice.setPrice(price);
							inventoryService.addItemPrice(itemPrice);
						}
					}
				}
			}
		} catch(NotExistException ex) {
			logger.error("Exception while saving new item : " + item.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.NOT_FOUND, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
		} catch(CustomUniqueKeyViolationException ex) {
			logger.error("Exception while saving new item : " + item.getName() + "-->" + ex.getMessage());
			ApiError apiError = new ApiError(ResponseCode.UNIQUE_KEY_VIOLATION, ex.getMessage());
			return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
		}
		logger.info("Item updated successfully : "+ item.getName());
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(ResponseCode.OK, "Item updated successfully"), HttpStatus.OK);
	}

}
