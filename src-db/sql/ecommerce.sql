CREATE OR REPLACE FUNCTION zse_shopdeletelog_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_cattagid varchar;
v_cur record;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN    
     select ad_org_id into new.ad_org_id from zse_shop where zse_shop_id=new.zse_shop_id;
  end if;
  
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_shopdeletelog_trg', 'zse_shopdeletelog');

CREATE TRIGGER zse_shopdeletelog_trg
  BEFORE INSERT
  ON zse_shopdeletelog FOR EACH ROW
  EXECUTE PROCEDURE  zse_shopdeletelog_trg();
 


CREATE OR REPLACE FUNCTION zse_shoptax_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_cattagid varchar;
v_cur record;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN    
     if new.title is null then new.title:='none'; end if;
     if new.externalid is null then new.externalid:='n/a'; end if;
  end if;
  
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_shoptax_trg', 'zse_shoptax');

CREATE TRIGGER zse_shoptax_trg
  BEFORE INSERT
  ON zse_shoptax FOR EACH ROW
  EXECUTE PROCEDURE  zse_shoptax_trg();
 

CREATE OR REPLACE FUNCTION zse_webshopcategorytrl_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_cattagid varchar;
v_cur record;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'UPDATE' or TG_OP = 'INSERT') THEN    
    update zse_webshopcategory set updated=now() where zse_webshopcategory_id=new.zse_webshopcategory_id;
  end if;
  
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_webshopcategorytrl_trg', 'zse_webshopcategory_trl');

CREATE TRIGGER zse_webshopcategorytrl_trg
  BEFORE INSERT or UPDATE OR DELETE
  ON zse_webshopcategory_trl FOR EACH ROW
  EXECUTE PROCEDURE  zse_webshopcategorytrl_trg();
 


CREATE OR REPLACE FUNCTION zse_prodshoptrl_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_cattagid varchar;
v_product varchar;
v_cur record;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'UPDATE' or TG_OP = 'INSERT') THEN    
    if (select count(*) from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id and ismaster='Y')>0 then
        select m_product_id into v_product from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
        update zse_product_shop set updated=now() where m_product_id=v_product;
    else
      update zse_product_shop set updated=now() where zse_product_shop_id=new.zse_product_shop_id;
    end if;
  end if;
  
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_prodshoptrl_trg', 'zse_product_shop_trl');

CREATE TRIGGER zse_prodshoptrl_trg
  BEFORE INSERT or UPDATE OR DELETE
  ON zse_product_shop_trl FOR EACH ROW
  EXECUTE PROCEDURE  zse_prodshoptrl_trg();
 


CREATE OR REPLACE FUNCTION zse_relation_product_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/


v_cur record;
v_shopid varchar;
v_reexidrelated varchar;
v_master varchar;
v_product_id varchar;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP in( 'UPDATE','INSERT')) THEN
    select ZSE_SHOP_ID into v_shopid from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
    select externalid into v_reexidrelated from zse_product_shop where ZSE_SHOP_ID=v_shopid and m_product_id=new.m_product_id;
    new.ZSE_SHOP_ID:=v_shopid;
    new.externalidrelatedproduct:=v_reexidrelated;
   -- raise notice '%' , '###'||coalesce(new.ZSE_SHOP_ID,'Ä')||coalesce(new.m_product_id,'xx');
   if TG_OP='INSERT' then
    update zse_product_shop set updated=now() where zse_product_shop_id=new.zse_product_shop_id;
   end if;
   
    
    if (select count(*) from zse_product_shop where ZSE_SHOP_ID=v_shopid and m_product_id=new.m_product_id)=0 then
        raise exception '%' , 'Das eingefügte Produkt muß dem Shop zugeordnet sein, um diese Funktion zu benutzen';
    end if;
    
    
  end if;
  
  IF (TG_OP = 'DELETE') THEN
   if old.externalidrelation is not null then
    insert into zse_shopdeletelog(ZSE_SHOPDELETELOG_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, EXTERNALID, ITEM,parentid)
    values (get_uuid(), old.AD_CLIENT_ID, old.AD_ORG_ID, old.CREATEDBY, old.UPDATEDBY, old.ZSE_SHOP_ID, old.externalidrelation, 'SURROGATE',old.externalidparent);
   end if;
   -- Propagate to aother Shops ifMaster
   select ismaster,m_product_id into v_master,v_product_id from zse_product_shop where zse_product_shop_id=old.zse_product_shop_id;
   if v_master='Y' then
     for v_cur in (select * from zse_product_shop where m_product_id=v_product_id and ismaster='N') 
     LOOP
        delete from zse_relation_product where zse_product_shop_id= v_cur.zse_product_shop_id and m_product_id=old.m_product_id;
     END LOOP;
   end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zse_relation_product_trg', 'zse_relation_product');


CREATE TRIGGER zse_relation_product_trg
  BEFORE INSERT or UPDATE OR DELETE
  ON zse_relation_product FOR EACH ROW
  EXECUTE PROCEDURE  zse_relation_product_trg();
    
CREATE OR REPLACE FUNCTION zse_relation_productafter_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/


v_cur record;
v_shopid varchar;
v_reexidrelated varchar;
v_product_id varchar;
v_master varchar;
v_reltype  zse_relation_product%ROWTYPE;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  
  IF (TG_OP = 'INSERT') THEN
   select ismaster,m_product_id into v_master,v_product_id from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
    if v_master='Y' then
       for v_cur in (select zse_product_shop_id,zse_shop_id from zse_product_shop where m_product_id=v_product_id and ismaster='N')
       LOOP -- Update Not-Master Products 
            -- Relatives
            select * from zse_relation_product into v_reltype where zse_relation_product_id=new.zse_relation_product_id;
            if (select count(*) from zse_relation_product where zse_product_shop_id=v_cur.zse_product_shop_id and m_product_id=v_reltype.m_product_id)=0 
                and (select count(*) from zse_product_shop where m_product_id=v_reltype.m_product_id and zse_shop_id=v_cur.zse_shop_id)>0 then
                v_reltype.createdby:=new.updatedby;
                v_reltype.updatedby:=new.updatedby;
                v_reltype.created:=now();
                v_reltype.updated:=now();
                v_reltype.zse_relation_product_id:=get_uuid();
                v_reltype.zse_product_shop_id:=v_cur.zse_product_shop_id;
                v_reltype.zse_shop_id:=v_cur.zse_shop_id;
                v_reltype.externalidrelation:=null;
                v_reltype.externalidrelatedproduct:=null;
                v_reltype.externalidparent:=null;
                insert into zse_relation_product SELECT v_reltype.*;
            end if;
       END LOOP; 
     end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zse_relation_productafter_trg', 'zse_relation_product');


CREATE TRIGGER zse_relation_productafter_trg
  AFTER INSERT
  ON zse_relation_product FOR EACH ROW
  EXECUTE PROCEDURE  zse_relation_productafter_trg();
    
    
CREATE OR REPLACE FUNCTION zse_prodshoptag_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_cattagid varchar;
v_product_id varchar;
v_cur record;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF ( TG_OP = 'INSERT') THEN    
    update zse_product_shop set updated=now() where zse_product_shop_id=new.zse_product_shop_id;
    select ZSE_SHOP_ID into v_shopid from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
    new.ZSE_SHOP_ID:=v_shopid;
  end if;
  IF (TG_OP = 'DELETE') THEN
    select m_product_id into v_product_id from zse_product_shop where zse_product_shop_id=old.zse_product_shop_id;
    if old.EXTERNALID is not null then
        --update zse_product_shop set updated=now() where zse_product_shop_id=old.zse_product_shop_id;
        insert into zse_shopdeletelog(ZSE_SHOPDELETELOG_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, EXTERNALID, ITEM)
        values (get_uuid(), old.AD_CLIENT_ID, old.AD_ORG_ID, old.CREATEDBY, old.UPDATEDBY, old.ZSE_SHOP_ID, old.EXTERNALID, 'PRODUCTTAG');
    end if;
    -- Propagate to aother Shops ifMaster
    if (select count(*) from zse_product_shop where zse_product_shop_id=old.zse_product_shop_id and ismaster='Y')>0 then            
       for v_cur in (select * from zse_product_shop where m_product_id=v_product_id and ismaster='N') 
       LOOP
                select zse_tag_id into v_cattagid from zse_tag where zse_shop_id= v_cur.zse_shop_id and 
                       commonname=(select commonname from zse_tag where zse_tag_id=old.zse_tag_id);
                delete from zse_tag_product where zse_product_shop_id= v_cur.zse_product_shop_id and zse_tag_id=v_cattagid;
        END LOOP;
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zse_prodshoptag_trg', 'zse_tag_product');


CREATE TRIGGER zse_prodshoptag_trg
  BEFORE INSERT OR UPDATE OR DELETE
  ON zse_tag_product FOR EACH ROW
  EXECUTE PROCEDURE  zse_prodshoptag_trg();
 
CREATE OR REPLACE FUNCTION zse_prodshoptagafter_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_cattagid varchar;
v_product_id varchar;
v_master varchar;
v_cur record;
v_tagtype  zse_tag_product%ROWTYPE;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF (TG_OP = 'INSERT') THEN
    select ismaster,m_product_id into v_master,v_product_id from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
    if v_master='Y' then
       for v_cur in (select zse_product_shop_id,zse_shop_id from zse_product_shop where m_product_id=v_product_id and ismaster='N')
       LOOP -- Update Not-Master Products 
            -- Tags
            select * from zse_tag_product into v_tagtype where zse_tag_product_id=new.zse_tag_product_id;
            select zse_tag_id into v_cattagid from zse_tag where zse_shop_id= v_cur.zse_shop_id and 
                    commonname=(select commonname from zse_tag where zse_tag_id=v_tagtype.zse_tag_id);
            if (select count(*) from zse_tag_product where zse_product_shop_id=v_cur.zse_product_shop_id and zse_tag_id=v_cattagid)=0 
                and v_cattagid is not null then
                v_tagtype.createdby:=new.updatedby;
                v_tagtype.updatedby:=new.updatedby;
                v_tagtype.created:=now();
                v_tagtype.updated:=now();
                v_tagtype.zse_tag_product_id:=get_uuid();
                v_tagtype.zse_tag_id:=v_cattagid;
                v_tagtype.zse_product_shop_id:=v_cur.zse_product_shop_id;
                v_tagtype.zse_shop_id:=v_cur.zse_shop_id;
                v_tagtype.externalid:=null;
                insert into zse_tag_product SELECT v_tagtype.*;
            end if;
       END LOOP;
     end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zse_prodshoptagafter_trg', 'zse_tag_product');


CREATE TRIGGER zse_prodshoptagafter_trg
  AFTER INSERT
  ON zse_tag_product FOR EACH ROW
  EXECUTE PROCEDURE  zse_prodshoptagafter_trg();
 
 
CREATE OR REPLACE FUNCTION zse_prodshopimage_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_product_id varchar;
v_cur record;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN    
    update zse_product_shop set updated=now() where zse_product_shop_id=new.zse_product_shop_id;
    select ZSE_SHOP_ID into v_shopid from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
    new.ZSE_SHOP_ID:=v_shopid;
  end if;
  if TG_OP = 'UPDATE' then
    if coalesce(old.ad_image_id,'')!=coalesce(new.ad_image_id,'') or old.seqno!=new.seqno or coalesce(old.url,'')!=coalesce(new.url,'') then
        update zse_product_shop set updated=now() where zse_product_shop_id=new.zse_product_shop_id;
        if (select count(*) from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id and  ismaster='Y')>0 then
            select m_product_id into v_product_id from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
            update zse_image_product set seqno=new.seqno,ad_image_id=new.ad_image_id,url=new.url where zse_product_shop_id in 
                (select zse_product_shop_id from zse_product_shop where m_product_id=v_product_id and ismaster='N') and
                seqno=old.seqno and coalesce(url,'')=coalesce(old.url,'') and coalesce(ad_image_id,'')=coalesce(old.ad_image_id,'');
        end if;
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN
    if old.EXTERNALID is not null then
        --update zse_product_shop set updated=now() where zse_product_shop_id=old.zse_product_shop_id;
        insert into zse_shopdeletelog(ZSE_SHOPDELETELOG_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, EXTERNALID, ITEM,parentid)
        values (get_uuid(), old.AD_CLIENT_ID, old.AD_ORG_ID, old.CREATEDBY, old.UPDATEDBY, old.ZSE_SHOP_ID, old.EXTERNALID, 'IMAGE',old.EXTERNALIDparent);
    end if;
    -- Propagate to aother Shops ifMaster
    select m_product_id into v_product_id from zse_product_shop where zse_product_shop_id=old.zse_product_shop_id;
    if (select count(*) from zse_product_shop where zse_product_shop_id=old.zse_product_shop_id and ismaster='Y')>0 then
        for v_cur in (select * from zse_product_shop where m_product_id=v_product_id and ismaster='N') 
        LOOP
            delete from zse_image_product where zse_product_shop_id= v_cur.zse_product_shop_id and ad_image_id=old.ad_image_id;
        END LOOP;
    end if;
    if (select count(*) from zse_image_product where ad_image_id=old.ad_image_id)=0 then
        delete from ad_image where ad_image_id=old.ad_image_id;
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zse_prodshopimage_trg', 'zse_image_product');


CREATE TRIGGER zse_prodshopimage_trg
  BEFORE INSERT OR UPDATE OR DELETE
  ON zse_image_product FOR EACH ROW
  EXECUTE PROCEDURE  zse_prodshopimage_trg();

CREATE OR REPLACE FUNCTION zse_prodshopimageafter_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_product_id varchar;
v_master varchar;
v_cur record;
v_imgtype  zse_image_product%ROWTYPE;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN
    select ismaster,m_product_id into v_master,v_product_id from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
    if v_master='Y' then
       for v_cur in (select zse_product_shop_id,zse_shop_id from zse_product_shop where m_product_id=v_product_id and ismaster='N')
       LOOP -- Update Not-Master Products 
            -- Pictures
            select * from zse_image_product into v_imgtype where zse_image_product_id=new.zse_image_product_id;
            -- Der Trick ist es, ad_image_id zu erhalten. das ist nur ein verweis.....
            if (select count(*) from zse_image_product where zse_product_shop_id=v_cur.zse_product_shop_id and ad_image_id=v_imgtype.ad_image_id)=0  then
                v_imgtype.createdby:=new.updatedby;
                v_imgtype.updatedby:=new.updatedby;
                v_imgtype.created:=now();
                v_imgtype.updated:=now();
                v_imgtype.zse_image_product_id:=get_uuid();
                v_imgtype.zse_product_shop_id:=v_cur.zse_product_shop_id;  
                v_imgtype.zse_shop_id:=v_cur.zse_shop_id;
                v_imgtype.externalid:=null;
                v_imgtype.externalidparent:=null;
                insert into zse_image_product  SELECT v_imgtype.*;
            end if;
       END LOOP;
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zse_prodshopimageafter_trg', 'zse_image_product');


CREATE TRIGGER zse_prodshopimageafter_trg
  AFTER INSERT 
  ON zse_image_product FOR EACH ROW
  EXECUTE PROCEDURE  zse_prodshopimageafter_trg();
  
  
CREATE OR REPLACE FUNCTION zse_prodshopcat_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_cattagid varchar;
v_product_id varchar;
v_cur record;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN    
    update zse_product_shop set updated=now() where zse_product_shop_id=new.zse_product_shop_id;
    select ZSE_SHOP_ID into v_shopid from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
    new.ZSE_SHOP_ID:=v_shopid;
  end if;
  IF (TG_OP = 'DELETE') THEN
    if old.EXTERNALID is not null then
        --update zse_product_shop set updated=now() where zse_product_shop_id=old.zse_product_shop_id;
        insert into zse_shopdeletelog(ZSE_SHOPDELETELOG_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, EXTERNALID, ITEM)
        values (get_uuid(), old.AD_CLIENT_ID, old.AD_ORG_ID, old.CREATEDBY, old.UPDATEDBY, old.ZSE_SHOP_ID, old.EXTERNALID, 'PRODUCTCATEGORY');
    end if;
    -- Propagate to other Shops ifMaster
    select m_product_id into v_product_id from zse_product_shop where zse_product_shop_id=old.zse_product_shop_id;
    if (select count(*) from zse_product_shop where zse_product_shop_id=old.zse_product_shop_id and ismaster='Y')>0 then            
       for v_cur in (select * from zse_product_shop where m_product_id=v_product_id and ismaster='N') 
       LOOP
                select zse_webshopcategory_id into v_cattagid from zse_webshopcategory where zse_shop_id= v_cur.zse_shop_id and 
                       commonname=(select commonname from zse_webshopcategory where zse_webshopcategory_id=old.zse_webshopcategory_id);
                
                delete from zse_webshopcategory_product where zse_product_shop_id= v_cur.zse_product_shop_id and zse_webshopcategory_id=v_cattagid;
        END LOOP;
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_prodshopcat_trg', 'zse_webshopcategory_product');

CREATE TRIGGER zse_prodshopcat_trg
  BEFORE INSERT or UPDATE OR DELETE
  ON zse_webshopcategory_product FOR EACH ROW
  EXECUTE PROCEDURE  zse_prodshopcat_trg();
  
CREATE OR REPLACE FUNCTION zse_prodshopcatafter_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_shopid varchar;
v_cattagid varchar;
v_product_id varchar;
v_master varchar;
v_cur record;
v_cattype  zse_webshopcategory_product%ROWTYPE;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN    
    select ismaster,m_product_id into v_master,v_product_id from zse_product_shop where zse_product_shop_id=new.zse_product_shop_id;
    if v_master='Y' then
        for v_cur in (select zse_product_shop_id,zse_shop_id from zse_product_shop where m_product_id=v_product_id and ismaster='N')
        LOOP -- Update Not-Master Products
            -- Kategories
            select * from zse_webshopcategory_product into v_cattype where zse_webshopcategory_product_id=new.zse_webshopcategory_product_id;
            select zse_webshopcategory_id into v_cattagid from zse_webshopcategory where zse_shop_id= v_cur.zse_shop_id and 
                       commonname=(select commonname from zse_webshopcategory where zse_webshopcategory_id=v_cattype.zse_webshopcategory_id);
            if (select count(*) from zse_webshopcategory_product where zse_product_shop_id=v_cur.zse_product_shop_id and  zse_webshopcategory_id=v_cattagid)=0 
               and v_cattagid is not null then
                    v_cattype.createdby:=new.updatedby;
                    v_cattype.updatedby:=new.updatedby;
                    v_cattype.created:=now();
                    v_cattype.updated:=now();
                    v_cattype.zse_webshopcategory_product_id:=get_uuid();
                    v_cattype.zse_product_shop_id:=v_cur.zse_product_shop_id;
                    v_cattype.zse_shop_id:=v_cur.zse_shop_id;
                    v_cattype.zse_webshopcategory_id:=v_cattagid;
                    v_cattype.externalid:=null;
                    insert into zse_webshopcategory_product SELECT v_cattype.*;
            end if;
        END LOOP;
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_prodshopcatafter_trg', 'zse_webshopcategory_product');

CREATE TRIGGER zse_prodshopcatafter_trg
  after INSERT
  ON zse_webshopcategory_product FOR EACH ROW
  EXECUTE PROCEDURE  zse_prodshopcatafter_trg();
 
 
CREATE OR REPLACE FUNCTION zse_prodshop_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
v_cur record;
v_cur2 record;
v_cattagid varchar;
v_masterid varchar;

-- Types
v_tagtype  zse_tag_product%ROWTYPE;
v_cattype  zse_webshopcategory_product%ROWTYPE;
v_reltype  zse_relation_product%ROWTYPE;
v_imgtype  zse_image_product%ROWTYPE;

BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF (TG_OP = 'DELETE') THEN
    if old.EXTERNALID is not null then
        insert into zse_shopdeletelog(ZSE_SHOPDELETELOG_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, EXTERNALID, ITEM)
        values (get_uuid(), old.AD_CLIENT_ID, old.AD_ORG_ID, old.CREATEDBY, old.UPDATEDBY, old.ZSE_SHOP_ID, old.EXTERNALID, 'PRODUCT');
        delete from zse_relation_product where ZSE_SHOP_ID=old.ZSE_SHOP_ID and m_product_id=old.m_product_id;
    end if;
  end if;
  IF (TG_OP = 'INSERT') THEN
    if (select count(*) from zse_product_shop where m_product_id=new.m_product_id and ismaster='Y' and zse_product_shop_id!=new.zse_product_shop_id)>0 and new.ismaster='Y' then
            raise exception '%','Nur ein führender Datensatz pro Artikel möglich';
    end if;
    if new.ismaster='N' and new.gotrigger='Y' then -- Is NOTmaster - fetch Data from master
        select zse_product_shop_id into  v_masterid from zse_product_shop  where m_product_id=new.m_product_id and ismaster='Y';
        -- Relatives
        for v_reltype in (select * from zse_relation_product where zse_product_shop_id=v_masterid)
        LOOP
            if (select count(*) from zse_product_shop where m_product_id=v_reltype.m_product_id and zse_shop_id=new.zse_shop_id)>0 then
                v_reltype.createdby:=new.updatedby;
                v_reltype.updatedby:=new.updatedby;
                v_reltype.created:=now();
                v_reltype.updated:=now();
                v_reltype.zse_relation_product_id:=get_uuid();
                v_reltype.zse_product_shop_id:=new.zse_product_shop_id;
                v_reltype.zse_shop_id:=new.zse_shop_id;
                v_reltype.externalidrelation:=null;
                v_reltype.externalidrelatedproduct:=null;
                v_reltype.externalidparent:=null;
                insert into zse_relation_product SELECT v_reltype.*;
            end if;
        END LOOP;
        -- Kategories
        for v_cattype in (select * from zse_webshopcategory_product where zse_product_shop_id=v_masterid)
        LOOP
            select zse_webshopcategory_id into v_cattagid from zse_webshopcategory where zse_shop_id= new.zse_shop_id and 
                    commonname=(select commonname from zse_webshopcategory where zse_webshopcategory_id=v_cattype.zse_webshopcategory_id);
            if v_cattagid is not null then
                v_cattype.createdby:=new.updatedby;
                v_cattype.updatedby:=new.updatedby;
                v_cattype.created:=now();
                v_cattype.updated:=now();
                v_cattype.zse_webshopcategory_product_id:=get_uuid();
                v_cattype.zse_product_shop_id:=new.zse_product_shop_id;
                v_cattype.zse_shop_id:=new.zse_shop_id;
                v_cattype.zse_webshopcategory_id:=v_cattagid;
                v_cattype.externalid:=null;
                insert into zse_webshopcategory_product SELECT v_cattype.*;
            end if;
        END LOOP;
        -- Tags
        for v_tagtype in (select * from zse_tag_product where zse_product_shop_id=v_masterid)
        LOOP
            select zse_tag_id into v_cattagid from zse_tag where zse_shop_id= new.zse_shop_id and 
                    commonname=(select commonname from zse_tag where zse_tag_id=v_tagtype.zse_tag_id);
            if v_cattagid is not null then
                v_tagtype.createdby:=new.updatedby;
                v_tagtype.updatedby:=new.updatedby;
                v_tagtype.created:=now();
                v_tagtype.updated:=now();
                v_tagtype.zse_tag_product_id:=get_uuid();
                v_tagtype.zse_tag_id:=v_cattagid;
                v_tagtype.zse_product_shop_id:=new.zse_product_shop_id;
                v_tagtype.zse_shop_id:=new.zse_shop_id;
                v_tagtype.externalid:=null;
                insert into zse_tag_product SELECT v_tagtype.*;
             end if;
        END LOOP;
        -- Pictures
        for v_imgtype in (select * from zse_image_product where zse_product_shop_id=v_masterid)
        LOOP
            -- Der Trick ist es, ad_image_id zu erhalten. das ist nur ein verweis.....
            v_imgtype.createdby:=new.updatedby;
            v_imgtype.updatedby:=new.updatedby;
            v_imgtype.created:=now();
            v_imgtype.updated:=now();
            v_imgtype.zse_image_product_id:=get_uuid();
            v_imgtype.zse_product_shop_id:=new.zse_product_shop_id;  
            v_imgtype.zse_shop_id:=new.zse_shop_id;
            v_imgtype.externalid:=null;
            v_imgtype.externalidparent:=null;
            insert into zse_image_product  SELECT v_imgtype.*;
        END LOOP;
    end if;    
    if new.ismaster='Y' and new.gotrigger='Y' then -- Is master - fetch Image from Header
      if (select count(*) from m_product where m_product_id=new.m_product_id and (ad_image_id is not null or imageurl is not null))>0 then
        v_imgtype:=null;
        v_imgtype.createdby:=new.updatedby;
        v_imgtype.updatedby:=new.updatedby;
        v_imgtype.ad_client_id=new.ad_client_id;
        v_imgtype.ad_org_id=new.ad_org_id;
        v_imgtype.isactive=new.isactive;
        v_imgtype.created:=now();
        v_imgtype.seqno:=10;
        v_imgtype.updated:=now();
        v_imgtype.zse_image_product_id:=get_uuid();
        v_imgtype.zse_product_shop_id:=new.zse_product_shop_id;  
        v_imgtype.zse_shop_id:=new.zse_shop_id;
        v_imgtype.externalid:=null;
        v_imgtype.externalidparent:=null;
        v_imgtype.url:=(select imageurl  from m_product where m_product_id=new.m_product_id);
        v_imgtype.ad_image_id:=(select ad_image_id  from m_product where m_product_id=new.m_product_id);
        insert into zse_image_product  SELECT v_imgtype.*;
       end if;
    end if;
    new.gotrigger:='Y';
  END IF; -- INSERT
  IF (TG_OP = 'UPDATE') THEN
    if new.ismaster='Y' then -- Is master - copy all data to dependent shop-entrys
        if (select count(*) from zse_product_shop where zse_product_shop_id!=new.zse_product_shop_id and m_product_id=new.m_product_id and ismaster='Y')>0 then
            raise exception '%','Nur ein führender Datensatz pro Artikel möglich';
        end if;
        update zse_product_shop set updated=now(),isorderable=new.isorderable ,  hideonnostock=new.hideonnostock ,  allworderonnostock=new.allworderonnostock 
                            where m_product_id=new.m_product_id and ismaster='N';                    
    end if; -- Is master - copy all data to dependent shop-entrys
    if coalesce(new.externalid,'') != coalesce(old.externalid,'') then 
        update zse_relation_product set externalidrelatedproduct=new.externalid where m_product_id=new.m_product_id and zse_shop_id=new.zse_shop_id;
    end if;
  END IF; --TG_OP = 'UPDATE'
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_prodshop_trg', 'zse_product_shop');

CREATE TRIGGER zse_prodshop_trg
  AFTER UPDATE OR DELETE OR INSERT
  ON zse_product_shop FOR EACH ROW
  EXECUTE PROCEDURE zse_prodshop_trg();
  
  
CREATE OR REPLACE FUNCTION zse_prodshop_bef_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF (TG_OP = 'INSERT') THEN
    if (select count(*) from zse_product_shop where m_product_id=new.m_product_id)=0 then
        new.ismaster:='Y';
        if new.ismaster='Y' and new.gotrigger='Y' then 
            -- Init Data with Data from Main Product
            select name into new.TITLE from m_product where m_product_id=new.m_product_id;
            select name into new.fullTITLE from m_product where m_product_id=new.m_product_id;
            select description into new.content from m_product where m_product_id=new.m_product_id;
            select documentnote into new.description from m_product where m_product_id=new.m_product_id;
        end if;
    end if;
    if new.ismaster='N' and new.gotrigger='Y' and (select count(*) from zse_product_shop  where m_product_id=new.m_product_id and ismaster='Y')>0 then
            select isorderable,  hideonnostock ,  allworderonnostock ,minorderqty,maxorderqty,maxstockshown 
                            into  new.isorderable,  new.hideonnostock ,  new.allworderonnostock,new.minorderqty,new.maxorderqty,new.maxstockshown 
                            from zse_product_shop  where m_product_id=new.m_product_id and ismaster='Y';
    end if;
  END IF;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_prodshop_bef_trg', 'zse_product_shop');

CREATE TRIGGER zse_prodshop_bef_trg
  BEFORE INSERT
  ON zse_product_shop FOR EACH ROW
  EXECUTE PROCEDURE zse_prodshop_bef_trg();
  
CREATE OR REPLACE FUNCTION zse_prodshop_del_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_sec numeric;
v_ist numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF (TG_OP = 'DELETE') THEN
    if (select updated from zse_shop where zse_shop_id=old.zse_shop_id)<now()- INTERVAL '1 Seconds' then
        update  zse_shop set deletecount=0  where zse_shop_id=old.zse_shop_id;
    end if;
    select deletesecurity into v_sec from zse_shop where zse_shop_id=old.zse_shop_id;
    select deletecount into v_ist  from zse_shop where zse_shop_id=old.zse_shop_id;
    if v_sec=v_ist then
        raise exception '%','Zu viele Datensätze. Um Fehler zu vermeiden wurde in Shop Einrichtung  ||  Webshops die max. mögliche Anzahl gleichzeitig löschbarer Artikel auf '||v_sec||' begrenzt. Erhöhen Sie ggf. diesen Wert. Denken Sie daran, dass OpenZ die gelöschten Artikel aus dem Shop entfernt.'; 
    end if;
    update zse_shop set deletecount=deletecount+1,updated=now() where zse_shop_id=old.zse_shop_id;
  END IF;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_prodshop_del_trg', 'zse_product_shop');

CREATE TRIGGER zse_prodshop_del_trg
  BEFORE DELETE
  ON zse_product_shop FOR EACH ROW
  EXECUTE PROCEDURE zse_prodshop_del_trg();
    
  
CREATE OR REPLACE FUNCTION zse_tag_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF (TG_OP = 'DELETE') THEN
    if old.EXTERNALID is not null then
        insert into zse_shopdeletelog(ZSE_SHOPDELETELOG_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, EXTERNALID, ITEM)
        values (get_uuid(), old.AD_CLIENT_ID, old.AD_ORG_ID, old.CREATEDBY, old.UPDATEDBY, old.ZSE_SHOP_ID, old.EXTERNALID, 'TAG');
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_tag_trg', 'zse_tag');

CREATE TRIGGER zse_tag_trg
  AFTER UPDATE OR DELETE
  ON zse_tag FOR EACH ROW
  EXECUTE PROCEDURE zse_tag_trg();
  
 CREATE OR REPLACE FUNCTION zse_webshopcategory_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF (TG_OP = 'DELETE') THEN
    if old.EXTERNALID is not null then
        insert into zse_shopdeletelog(ZSE_SHOPDELETELOG_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, EXTERNALID, ITEM)
        values (get_uuid(), old.AD_CLIENT_ID, old.AD_ORG_ID, old.CREATEDBY, old.UPDATEDBY, old.ZSE_SHOP_ID, old.EXTERNALID, 'CATEGORY');
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_webshopcategory_trg', 'zse_webshopcategory');

CREATE TRIGGER zse_webshopcategory_trg
  AFTER UPDATE OR DELETE
  ON zse_webshopcategory FOR EACH ROW
  EXECUTE PROCEDURE zse_webshopcategory_trg();
  
  
  
CREATE OR REPLACE FUNCTION zse_getqtyonhand4webshop(p_shopid varchar,p_externalid varchar) RETURNS numeric AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_qtyoh numeric:=0;
v_maxstock numeric;
v_product varchar;
v_warehouse varchar;
BEGIN
  --raise notice '%','XX'||coalesce(p_shopid,'NS')||'#'||coalesce(p_externalid,'NE');
  select m_product_id,maxstockshown into v_product,v_maxstock from zse_product_shop where zse_shop_id=p_shopid and externalid=p_externalid;
  if v_product is null then
    return 0;
  end if;
  select m_warehouse_id into v_warehouse  from zssi_smartinvoiceprefs where zse_shop_id=p_shopid;
  if v_warehouse is null then
    return 0;
  end if;
  select M_BOM_Qty_Available(v_product,v_warehouse,null) into v_qtyoh;
  if v_maxstock is not null then
    if v_qtyoh<=v_maxstock then
        return v_qtyoh;
    else
        return v_maxstock;
    end if;
  else
    return v_qtyoh;
  end if;
END;
$body$
LANGUAGE 'plpgsql';


     
CREATE OR REPLACE FUNCTION zse_copyShopComplete(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message character varying:='Sucess';
v_fromId varchar;
v_toId varchar;
v_cur record;
v_cur2 record;
v_i numeric:=0;
v_newpshopId varchar;
v_cattagid varchar;

-- Rowtypes
v_tagtype  zse_tag%ROWTYPE;
v_cattype  zse_webshopcategory%ROWTYPE;
v_prodtype  zse_product_shop%ROWTYPE;
v_ptagtype  zse_tag_product%ROWTYPE;
v_pcattype  zse_webshopcategory_product%ROWTYPE;
v_reltype  zse_relation_product%ROWTYPE;
v_imgtype  zse_image_product%ROWTYPE;
v_trltype  zse_product_shop_trl%ROWTYPE;
v_notax varchar;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User  from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    IF (v_Record_ID IS NOT NULL) then
        FOR v_cur IN (SELECT pi.Record_ID, p.ParameterName,  p.P_String,     p.P_Number,   p.P_Date   
                      FROM AD_PINSTANCE pi, AD_PINSTANCE_PARA p 
                      WHERE pi.AD_PInstance_ID=p.AD_PInstance_ID and pi.AD_PInstance_ID=p_PInstance_ID
        )
      LOOP

        if v_cur.ParameterName='fromshop' then v_fromId:=v_cur.P_String; end if;
        if v_cur.ParameterName='toshop' then v_toId:=v_cur.P_String; end if;

      END LOOP; -- Get Parameter
    END if;
    if v_Record_ID is null then
       RAISE exception '%','Pinstance not found-Exiting ' || p_PInstance_ID;   
    end if;
    -- Test, If TAX is set correctly
    /*
    for v_cur in (
       select distinct p.c_tax_id from  m_product p,zse_product_shop s where p.c_tax_id is not null and s.m_product_id=p.m_product_id and s.zse_shop_id=v_fromId and
          not exists (select 0 from  zse_shoptax st where st.c_tax_id=p.c_tax_id and s.zse_shop_id=v_toId)
       union
       select distinct pc.c_tax_id from  m_product p,m_product_category pc,zse_product_shop s where pc.m_product_category_id=p.m_product_category_id and
          pc.c_tax_id is not null and p.c_tax_id is null and s.m_product_id=p.m_product_id and s.zse_shop_id=v_fromId and
          not exists (select 0 from  zse_shoptax st where st.c_tax_id=p.c_tax_id and s.zse_shop_id=v_toId)
       union select c_tax_id from ad_org_acctschema where ad_org_id=(select  ad_org_id from zse_shop where zse_shop_id =v_toId))
    LOOP
       if v_notax is null then
         v_notax:= 'Steuerarten in  Einstellungen ECommerce-Shops || Steuerarten im Shop nicht zugeordnet. Ordnen Sie dem Ziel-Shop folgende Steuerarten zu: ';
       else 
         v_notax:=v_notax||';';
       end if;
       v_notax:=v_notax||(select name from c_tax where c_tax_id=v_cur.c_tax_id);
    END LOOP;
    if v_notax is not null then
        raise exception '%',v_notax;
    end if;
    */
    -- Copy Tags
    for v_tagtype  in (select * from zse_tag where zse_shop_id=v_fromId)
    LOOP
        if (select count(*) from zse_tag where zse_shop_id=v_toId and commonname=v_tagtype.commonname)=0 then
            v_tagtype.zse_tag_id:=get_uuid();
            v_tagtype.zse_shop_id:=v_toId;
            v_tagtype.externalid:=null;
            v_tagtype.createdby:=v_User;
            v_tagtype.updatedby:=v_User;
            v_tagtype.created:=now();
            v_tagtype.updated:=now();
            insert into zse_tag SELECT v_tagtype.*;
        end if;
    END LOOP;
    -- Copy Categories
    for v_cattype in (select * from zse_webshopcategory where zse_shop_id=v_fromId)
    LOOP
        if (select count(*) from zse_webshopcategory where zse_shop_id=v_toId and commonname=v_cattype.commonname)=0 then
            v_cattype.zse_webshopcategory_id:=get_uuid();
            v_cattype.zse_shop_id:=v_toId;
            v_cattype.externalid:=null;
            v_cattype.createdby:=v_User;
            v_cattype.updatedby:=v_User;
            v_cattype.created:=now();
            v_cattype.updated:=now();
            insert into zse_webshopcategory SELECT v_cattype.*;
        end if;
    END LOOP;
    -- Copy Products    
    for v_prodtype in (select * from zse_product_shop where zse_shop_id=v_fromId)
    LOOP
        if (select count(*) from zse_product_shop where zse_shop_id=v_toId and m_product_id=v_prodtype.m_product_id)=0 then
            v_prodtype.zse_product_shop_id:=get_uuid();
            v_prodtype.zse_shop_id:=v_toId;
            v_prodtype.externalid:=null;
            v_prodtype.externalid2:=null;
            v_prodtype.createdby:=v_User;
            v_prodtype.updatedby:=v_User;
            v_prodtype.created:=now();
            v_prodtype.updated:=now();
            if v_prodtype.ismaster='Y' then
                v_prodtype.ismaster:='N';
                v_prodtype.title:=null;
                v_prodtype.fulltitle:=null;
                v_prodtype.content:=null;
                v_prodtype.description:=null;
            end if;
            insert into zse_product_shop SELECT v_prodtype.*;
            v_i:=v_i+1;
        end if;       
    END LOOP;  
    -- Copy Product related Data
    for v_prodtype in (select * from zse_product_shop where zse_shop_id=v_fromId)
    LOOP
        select zse_product_shop_id into v_newpshopId from zse_product_shop where zse_shop_id=v_toId and m_product_id=v_prodtype.m_product_id;
        if v_newpshopId is not null then
            for v_reltype in (select * from zse_relation_product where zse_product_shop_id=v_prodtype.zse_product_shop_id)
            LOOP
              if (select count(*) from zse_relation_product where zse_product_shop_id=v_newpshopId and m_product_id=v_reltype.m_product_id)=0 then
                v_reltype.zse_product_shop_id:=v_newpshopId;
                v_reltype.zse_relation_product_id:=get_uuid();
                v_reltype.zse_shop_id:=v_toId;
                v_reltype.createdby:=v_User;
                v_reltype.updatedby:=v_User;
                v_reltype.created:=now();
                v_reltype.updated:=now();
                v_reltype.externalidrelation:=null;
                v_reltype.externalidrelatedproduct:=null;
                v_reltype.externalidparent:=null;
                insert into zse_relation_product select v_reltype.*;
              end if;
            END LOOP;
            -- Kategories
            for v_pcattype in (select * from zse_webshopcategory_product where zse_product_shop_id=v_prodtype.zse_product_shop_id)
            LOOP
                select zse_webshopcategory_id into v_cattagid from zse_webshopcategory where zse_shop_id= v_toId and 
                        commonname=(select commonname from zse_webshopcategory where zse_webshopcategory_id=v_pcattype.zse_webshopcategory_id);
                if v_cattagid is not null and 
                (select count(*) from zse_webshopcategory_product where zse_product_shop_id=v_newpshopId and zse_webshopcategory_id=v_cattagid)=0 then
                    v_pcattype.createdby:=v_User;
                    v_pcattype.updatedby:=v_User;
                    v_pcattype.created:=now();
                    v_pcattype.updated:=now();
                    v_pcattype.zse_webshopcategory_product_id:=get_uuid();
                    v_pcattype.zse_product_shop_id:=v_newpshopId;
                    v_pcattype.zse_shop_id:=v_toId;
                    v_pcattype.zse_webshopcategory_id:=v_cattagid;
                    v_pcattype.externalid:=null;
                    insert into zse_webshopcategory_product SELECT v_pcattype.*;
                end if;
            END LOOP;
            -- Tags
            for v_ptagtype in (select * from zse_tag_product where zse_product_shop_id=v_prodtype.zse_product_shop_id)
            LOOP
                select zse_tag_id into v_cattagid from zse_tag where zse_shop_id= v_toId and 
                        commonname=(select commonname from zse_tag where zse_tag_id=v_ptagtype.zse_tag_id);
                if v_cattagid is not null and
                (select count(*) from zse_tag_product where zse_product_shop_id=v_newpshopId and zse_tag_id=v_cattagid)=0 then
                    v_ptagtype.createdby:=v_User;
                    v_ptagtype.updatedby:=v_User;
                    v_ptagtype.created:=now();
                    v_ptagtype.updated:=now();
                    v_ptagtype.zse_tag_product_id:=get_uuid();
                    v_ptagtype.zse_tag_id:=v_cattagid;
                    v_ptagtype.zse_product_shop_id:=v_newpshopId;
                    v_ptagtype.zse_shop_id:=v_toId;
                    v_ptagtype.externalid:=null;
                    insert into zse_tag_product SELECT v_ptagtype.*;
                end if;
            END LOOP;
            -- Pictures
            for v_imgtype in (select * from zse_image_product where zse_product_shop_id=v_prodtype.zse_product_shop_id)
            LOOP
            if (select count(*) from zse_image_product where zse_product_shop_id=v_newpshopId and ad_image_id=v_imgtype.ad_image_id)=0 then             
                -- Der Trick ist es hier, ad_imkage zu kopieren, sonst hätte es ja über den Master mitkommen sollen...
                select ad_copyimage(v_imgtype.ad_image_id,v_User) into v_imgtype.ad_image_id;
                v_imgtype.createdby:=v_User;
                v_imgtype.updatedby:=v_User;
                v_imgtype.created:=now();
                v_imgtype.updated:=now();
                v_imgtype.zse_image_product_id:=get_uuid();
                v_imgtype.zse_product_shop_id:=v_newpshopId;
                v_imgtype.zse_shop_id:=v_toId;
                v_imgtype.externalid:=null;
                v_imgtype.externalidparent:=null;
                insert into zse_image_product  SELECT v_imgtype.*;
            end if;
            END LOOP;
            if (select count(*) from zse_product_shop where m_product_id=v_prodtype.m_product_id and ismaster='Y')=0 then --No Master
                -- Translations, when no Master Copy
                for v_trltype in (select * from zse_product_shop_trl where zse_product_shop_id=v_prodtype.zse_product_shop_id)
                LOOP
                if (select count(*) from zse_product_shop_trl where zse_product_shop_id=v_newpshopId and ad_language=v_trltype.ad_language)=0 then             
                    v_trltype.createdby:=v_User;
                    v_trltype.updatedby:=v_User;
                    v_trltype.created:=now();
                    v_trltype.updated:=now();
                    v_trltype.zse_product_shop_trl_id:=get_uuid();
                    v_trltype.zse_product_shop_id:=v_newpshopId;
                    insert into zse_product_shop_trl  SELECT v_trltype.*;
                end if;
                END LOOP;
           end if; -- No Master
           
        end if; -- New Product exyists in shop
    END LOOP;
    v_message := v_i || ' Artikel  kopiert';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
CREATE OR REPLACE FUNCTION zse_shopordererror_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF (TG_OP = 'DELETE') THEN
    if old.EXTERNALID is not null then
        insert into zse_shoporderstatus(zse_shoporderstatus_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, EXTERNALID, shopoderno,status)
        values (get_uuid(), old.AD_CLIENT_ID, old.AD_ORG_ID, old.CREATEDBY, old.UPDATEDBY, old.ZSE_SHOP_ID, old.EXTERNALID, old.shopoderno,'RETRY');
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zse_shopordererror_trg', 'zse_shopordererror');

CREATE TRIGGER zse_shopordererror_trg
  AFTER  DELETE
  ON zse_shopordererror FOR EACH ROW
  EXECUTE PROCEDURE zse_shopordererror_trg();
  
CREATE OR REPLACE FUNCTION zse_order_ecommercestatus(p_recordid varchar) RETURNS VOID AS
$body$
DECLARE 
    v_docst varchar;
    v_delsts varchar;
BEGIN
   select docstatus,deliverycomplete into v_docst , v_delsts from c_order where issotrx='Y' and c_order_id=p_recordid;
   if v_docst='CO' then
        update zse_shoporderstatus set status='PROCESSING ORDER',updated=now(),isrefelctiondone='N' where c_order_id=p_recordid and issotrx='Y';
   end if;
   if v_docst='VO' then
        update zse_shoporderstatus set status='ORDER CANCELLED',updated=now(),isrefelctiondone='N' where c_order_id=p_recordid and issotrx='Y';
   end if;
   if v_delsts='Y' then
        update zse_shoporderstatus set status='GOODS IN TRANSIT',updated=now(),deliverycomplete='Y',isrefelctiondone='N' where c_order_id=p_recordid and issotrx='Y';
   end if;
   if v_delsts='N' then
    if (select count(*) from m_inout m where c_order_id=p_recordid and  docstatus='CO' and movementtype='C+')>0  then
        update zse_shoporderstatus set status='SHIPMENT RETURNED',updated=now(),deliverycomplete='N',isrefelctiondone='N' where c_order_id=p_recordid and issotrx='Y';
    end if;
   end if;
END;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION zse_invoice_ecommercestatus(p_recordid varchar) RETURNS VOID AS
$body$
DECLARE 
    v_status varchar;
    v_order  varchar;
BEGIN
 -- Bankeinzug, Überweisung, Bar
 select i.ispaid,o.c_order_id into v_status,v_order from c_invoice i,c_order o where o.c_order_id=i.c_order_id and i.c_invoice_id=p_recordid 
        and i.paymentrule in ('B','R','P') and i.issotrx='Y';
 if coalesce(v_status,'#')='Y' then
    update zse_shoporderstatus set status='PAYMENT COMPLETED',updated=now(),ispaid='Y',isrefelctiondone='N' where c_order_id=v_order 
           and issotrx='Y';
 end if;
 if coalesce(v_status,'#')='N' then
    update zse_shoporderstatus set status='PAYMENT CANCELLED',updated=now(),ispaid='N',isrefelctiondone='N' where c_order_id=v_order 
           and issotrx='Y';
 end if;
END;
$body$
LANGUAGE 'plpgsql';




CREATE OR REPLACE FUNCTION zse_shoporderstatus_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2015 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  IF (TG_OP != 'DELETE') THEN
    if (select paymentrule from c_order where c_order_id=new.c_order_id)='K' then
        new.ispaid='Y'; 
    end if;
  end if;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zse_shoporderstatus_trg', 'zse_shoporderstatus');

CREATE TRIGGER zse_shoporderstatus_trg
  BEFORE INSERT OR UPDATE
  ON zse_shoporderstatus FOR EACH ROW
  EXECUTE PROCEDURE zse_shoporderstatus_trg();
  
  
  
CREATE OR REPLACE FUNCTION zse_bulkproductshopassignment(p_userid varchar,p_shopid varchar,p_product varchar,p_category varchar,p_tag varchar,
                             p_isorderable varchar,p_hideonnostock varchar,p_allworderonnostock varchar,p_maxstockshown numeric,p_minorderqty numeric,
                             p_maxorderqty numeric) RETURNS VARCHAR AS
$body$
DECLARE 
    v_org varchar;
    v_client varchar:='C726FEC915A54A0995C568555DA5BB3C';
    v_pshopid varchar;
    v_ismaster varchar;
BEGIN
   if p_userid is null then return 'COMPILE'; end if;
   select ad_org_id into v_org from zse_shop where zse_shop_id=p_shopid;
   select zse_product_shop_id into v_pshopid from zse_product_shop where m_product_id=p_product and zse_shop_id=p_shopid;
   if v_pshopid is null then
    if p_allworderonnostock='NON' then p_allworderonnostock:='Y'; end if;
    if p_isorderable='NON' then p_isorderable:='N'; end if;
    if p_hideonnostock='NON' then p_hideonnostock:='N'; end if;
    if (select count(*) from zse_product_shop where m_product_id=p_product and ismaster='Y')>0 then
        v_ismaster:='N';
    else
        v_ismaster:='Y';
    end if;
    insert into zse_product_shop(zse_product_shop_id, ad_client_id, ad_org_id, createdby, updatedby, zse_shop_id, m_product_id,
                                 isorderable, hideonnostock, allworderonnostock, maxstockshown, minorderqty, maxorderqty,ismaster)
           values (get_uuid(),v_client,v_org,p_userid,p_userid,p_shopid,p_product,p_isorderable,p_hideonnostock,p_allworderonnostock,
                   p_maxstockshown,p_minorderqty,p_maxorderqty,v_ismaster);

   else
    update zse_product_shop set updated=now(),updatedby=p_userid,
                                isorderable= case when p_isorderable='NON' then isorderable else p_isorderable end,
                                hideonnostock= case when p_hideonnostock='NON' then hideonnostock else p_hideonnostock end,
                                allworderonnostock= case when p_allworderonnostock='NON' then allworderonnostock else p_allworderonnostock end,
                                maxstockshown=p_maxstockshown, minorderqty=p_minorderqty, maxorderqty=p_maxorderqty
                            where  zse_product_shop_id=v_pshopid;
   end if;
   if p_category is not null and (select count(*) from zse_webshopcategory_product where zse_webshopcategory_id = p_category and zse_product_shop_id=v_pshopid)=0 then
        insert into zse_webshopcategory_product(zse_webshopcategory_product_id, ad_client_id, ad_org_id, createdby, updatedby, zse_product_shop_id, 
                zse_webshopcategory_id, zse_shop_id)
        values (get_uuid(),v_client,v_org,p_userid,p_userid,v_pshopid,p_category,p_shopid);
   end if;
   if p_tag is not null and (select count(*) from zse_tag_product where zse_tag_id = p_category and zse_product_shop_id=v_pshopid)=0 then
        insert into zse_tag_product(zse_tag_product_id, ad_client_id, ad_org_id, createdby, updatedby, zse_product_shop_id, zse_tag_id, zse_shop_id)
        values (get_uuid(),v_client,v_org,p_userid,p_userid,v_pshopid,p_tag,p_shopid);
   end if;
   return 'OK';
END;
$body$
LANGUAGE 'plpgsql';
  