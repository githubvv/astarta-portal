package astarta.web.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import astarta.business.service.OrgStructureService;
import astarta.db.exception.AbstractPortalDBException;
import astarta.security.config.UserDetailsExt;
import astarta.web.config.jackson.JsonMapper;
import astarta.web.model.EmployeeMaker;
import astarta.web.model.UserModel;

@RestController
public class OrgStructureController {
	@Autowired
	private OrgStructureService orgStructureService;
	@Autowired
	private JsonMapper jacksonMapper;

	@RequestMapping(value = "/org-structure/users/add/load-from-1c", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> loadUsersFrom1C(@RequestBody Set<UserModel> userList)
			throws AbstractPortalDBException {
		if (userList == null || userList.isEmpty())
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		else {
			orgStructureService.saveUsers(userList);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/org-structure/employee/enable/load-from-1c", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<HttpStatus> setEmplsEnable(@RequestBody List<EmployeeMaker> emplsMaker)
			throws AbstractPortalDBException {
		orgStructureService.setEmplsEnable(emplsMaker);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(value = "/org-structure/users/current-user/check-authentication", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ObjectNode> checkAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ObjectNode authJSON = jacksonMapper.createObjectNode();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			UserDetailsExt authUser = (UserDetailsExt) authentication.getPrincipal();
			try {
				String userDetails = jacksonMapper.writeValueAsString(authUser.getUserData());
				authJSON.put("status", "success");
				authJSON.put("userdetails", userDetails);
				return new ResponseEntity<>(authJSON, HttpStatus.OK);
			} catch (JsonProcessingException e) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}

		}
		return new ResponseEntity<>(authJSON, HttpStatus.OK);
	}
}